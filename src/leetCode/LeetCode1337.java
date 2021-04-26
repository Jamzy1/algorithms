package leetCode;


/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 1、从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 2、从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 3、重复步骤 2 ，直到你没法从 s 中选择字符。
 * 4、从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 5、从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 6、重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * <p>
 * <p>
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba
 */
public class LeetCode1337 {

    public static void main(String[] args) {

        String s = "aaaabbbbcccc";
        LeetCode1337 leetCode1337 = new LeetCode1337();
        System.out.println(leetCode1337.sortString(s));

    }

    /**
     * 先将字符串用桶排序装进桶内
     * 大循环遍历(步骤1~6)
     * 大循环里面是两个小循环，一个是先从大到小，一个是从小到大
     *
     * @param s
     * @return
     */
    public static String sortString(String s) {

//        桶排序，将s装进桶数组
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        StringBuffer res = new StringBuffer();

//        大循环
        while (res.length()<s.length()){

//            步骤1-3
            for (int i = 0; i < 26; i++) {
                if (nums[i]>0){
                    res.append((char)(i+'a'));
                    nums[i]--;
                }
            }

//            步骤4-6
            for (int i = 25; i >=0; i--) {
                if (nums[i]>0){
                    res.append((char)(i+'a'));
                    nums[i]--;
                }
            }
        }
        return res.toString();
    }
}
