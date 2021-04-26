package 字符串;


/**
 *
 * KMP算法应用
 * 给定一个字符串，在其 后面 添加任意字符(不能为空)，使新字符串是以 原字符串的两倍结尾 的最短字符串
 *
 * 思路：求其最长前缀数组，并多求一位，目的就是这最后一位，最后一位代表整个字符串前后有多少相同的部分
 *
 */
public class KMP_ShortestHaveTwice {

    public static String answer(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
//        转为数组
        char[] chas = str.toCharArray();
//        如果只有一个，直接加一
        if (chas.length == 1) {
            return str + str;
        }
//        两个字符，如果相等就只加一个，不等就都加
        if (chas.length == 2) {
            return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
        }

        int endNext = endNextLength(chas);
//        截这一个数量到最后的部分
        return str + str.substring(endNext);
    }

    public static int endNextLength(char[] chas) {
//        求其最长前缀数组，并多求一位，目的就是这最后一位，最后一位代表整个字符串前后有多少相同的部分
        int[] next = new int[chas.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (chas[pos - 1] == chas[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
//        返回整个字符串前后有多少相同字母的数量
        return next[next.length - 1];
    }

    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));

    }
}
