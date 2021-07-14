package 回溯.字符串;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 */
public class LeetCode22 {

    //递归，没有回溯的过程
    // 因为每一次尝试，都使用新的字符串变量String，所以无需回溯
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        //深度优先遍历，搜索可能的结果
        backTrack(n, n, "");
        return res;
    }

    // 在递归终止的时候，直接把它添加到结果集即可
    private void backTrack(int left, int right, String str){
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        if(left>0){
            backTrack(left-1,right,str+"(");
        }
        if(right>left){
            backTrack(left,right-1,str+")");
        }
    }


    //回溯二
    public List<String> generateParenthesis2(int n) {
        backTrack(n, n, new StringBuilder());
        return res;
    }
    private void backTrack(int left, int right, StringBuilder str){
        if(left == 0 && right == 0){
            res.add(str.toString());
            return;
        }
        if(left>0){
            str.append("(");
            backTrack(left-1,right,str);
            str.deleteCharAt(str.length()-1);
        }
        if(right>left){
            str.append(")");
            backTrack(left,right-1,str);
            str.deleteCharAt(str.length()-1);
        }
    }

}
