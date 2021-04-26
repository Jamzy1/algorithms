package 字符串;

/**
 * 给两串字符串，匹配字符串，串1里面是否有串2,返回串2在串1中的起始位置
 *
 * 1、最长前缀数组：给定一个字符数组，求数组中的所有结点的最长前缀数
 *
 *  最长前缀数：该节点前面的所有结点，首尾各找出一段字符串相匹配，匹配的最长字符串长度就是最长前缀数。
 *  abcabcak：k的最长前缀数为4；a的最长前缀数默认为-1；b的默认为0
 *
 * 2、有最长前缀数组后，利用最长前缀数组进行匹配加速，可跳过很多无须匹配的字符串
 *
 * 3、如何求最长前缀数组
 *
 */
public class KMP {

//    默认s是大字符串，m是小字符串
    public static int getIndexOf(String s, String m) {

        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
//        将两个字符串转换为字符数组
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
//        两个指针分别指向两个字符数组
        int si = 0;
        int mi = 0;

//        获得数组二的最长前缀数组
        int[] next = getNextArray(ms);

        while (si < ss.length && mi < ms.length) {
//            如果开始匹配到相等，则进入匹配，指针都后移
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
//                如果没遇到和 数组二的第一个结点 相同的，则大指针继续走（指针小已经跳到第一个了，没地方跳了）
            } else if (next[mi] == -1) {
                si++;
//                如果进入匹配 ，遇到不相等的，直接小指针跳到其最长前缀的地方（加速之处）
            } else {
                mi = next[mi];
            }
        }

//        如果小字符串指针已经划过整个小字符串，说明匹配上了
        return mi == ms.length ? si - mi : -1;
    }

//    获得一个字符数组所有的结点的最长前缀，并返回一个数组
    public static int[] getNextArray(char[] ms) {
//        第一个结点默认-1，第二个为0
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
//        遍历指针
        int pos = 2;
//        也是指针、也是前缀长度
        int cn = 0;
//        数组范围长度内
        while (pos < next.length) {
//            如果 结点的前一个 等于 上一个结点最长前缀的下一个，直接加一
            if (ms[pos - 1] == ms[cn]) {        //比较的都是原数组的数
                next[pos++] = ++cn;//赋值完pos再加的  cn是原数组下标、也是最长前缀长度
//                如果不等，且cn在next上有值，直接比较cn的
            } else if (cn > 0) {
                cn = next[cn];
            } else {
//                否则就等于0
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }


}
