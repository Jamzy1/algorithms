package 回溯.字符串;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/submissions/
 * 大小写转换组合
 * //A~Z与a~z于ASCII表中相差32
 * 大写：65-90   小写：97-122  差的这32刚好是0010 0000这一bit位
 * 所以直接进行异或：如果是大写：0^1=1; 小写：1^1=0
 */
public class LeetCode784 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        res.add(s);
        backTrack(s.toCharArray(), 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 5);
    }

    private void backTrack(char[] strs, int start) {
        for (int i = start; i < strs.length; i++) {
            //判断是否为字母
            if (strs[i] > '9') {
                //大小写转换
                strs[i] ^= (1 << 5);    //1 << 5 = 32
                //记录子集
                res.add(String.valueOf(strs));
                //大小写转换后进入下一层
                backTrack(strs, i + 1);
                //转换回来
                strs[i] ^= (1 << 5);
            }
        }
    }
}
