package 字符串;


/**
 * 求一个字符串里面的最长回文序列
 *
 * 思路：马拉车算法( O(n) ),遍历一遍数组，判断每个的最长回文序列
 * 从左往右遍历
 *
 *
 * 回文右边界：从i开始更新，每次都是以i问中心的最右回文边界
 * 
 *
 */
public class Manacher {

//        创建一个长数组，为了在原数组的每个元素两边加上符号 "#",解决偶字符串问题
    public static char[] manacherString(String str) {
//        转为数组
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
//        整理原字符串
        char[] charArr = manacherString(str);
//        新数组用来存放每个结点的回文半径
        int[] pArr = new int[charArr.length];
        int C = -1; //取得最右边界时的回文中心
        int R = -1; //字符串中的回文右边界(从i开始更新，每次都是以i问中心的最右回文边界)
        int max = Integer.MIN_VALUE;

//        遍历字符串，i表示回文中心
        for (int i = 0; i != charArr.length; i++) {

//            [2 * index - i] 是i关于index的对称点的下标
//            对称点的回文半径和R到i的距离，哪个小，哪个就是i的回文半径---(即看对称点回文半径有没有在L-R间)
//            确定起码不用验的区域，如果i在R外面或者压线(只有1：我自己)
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
//            以i为中心的回文序列在字符串长度内
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
//                看回文序列还能否变长
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }

//            更新此时的最右边界和中心
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
