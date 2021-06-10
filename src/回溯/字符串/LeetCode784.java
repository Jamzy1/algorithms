package 回溯.字符串;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/submissions/
 * 大小写转换组合
 */
public class LeetCode784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        res.add(s);
        backTrack(s.toCharArray(),0);
        return res;
    }
    private void backTrack(char[] strs, int start){
        for(int i = start; i<strs.length; i++){
            //判断是否为字母
            if(strs[i]>'9'){
                //大小写转换
                strs[i] ^=(1<<5);
                //记录子集
                res.add(String.valueOf(strs));
                //大小写转换后进入下一层
                backTrack(strs,i+1);
                //转换回来
                strs[i] ^= (1<<5);
            }
        }
    }
}
