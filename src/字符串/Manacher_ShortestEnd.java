package 字符串;


/**
 * 在字符串后面添加字符串，要求使新字符串是回文序列，并新字符串要尽可能短，返回要添加的字符串
 *
 * 思路：求字符串中最右回文边界包含最后一个结点的最长回文序列，求出后直接把不是该序列内的序列倒序加到最后面
 *
 *
 */
public class Manacher_ShortestEnd {

//    整理字符串
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
//        manacher过程
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
//            回文右边界到数组最后时 (因为每次都是i从0遍历来的，所以该回文序列是到达最后一个元素的最长回文序列)
            if (pR == charArr.length) {
//                取半径值
                maxContainsEnd = pArr[i];
                break;
            }
        }
//        创建答案数组，长度为总长减maxContainsEnd(原本要*2，但数组处理过，中间加了#)
        char[] res = new char[str.length() - maxContainsEnd + 1];
        System.out.println(maxContainsEnd);//包含最后元素的最长回文长度
//        逆序输出
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = charArr[i * 2 + 1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "abcd123321";
        System.out.println(shortestEnd(str2));

    }
}
