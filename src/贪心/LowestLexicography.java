package 贪心;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 字典序
 * 将给定的字符串数组组合成一串最小的字符串     规定（a<z）
 *
 * 先将字符串按自己定义的大小顺序排序，然后直接拼接
 */
public class LowestLexicography {

    public static class MyComparator implements Comparator<String> {
        @Override
//        如果a+b大于b+a，b+a在前
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
