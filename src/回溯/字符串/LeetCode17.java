package 回溯.字符串;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 电话号码组合
 * 这里也是回溯，每个数字对应一个字符串，然后每个字符串取出一个字符去排列
 */
public class LeetCode17 {
    //用map来存储电话号码数组与符号的映射
    private Map<Character,String> map;

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        dfs(0, res, digits, new StringBuffer());
        return res;
    }
    public void dfs(int index, List<String> res, String digits, StringBuffer buffer){
        if(index == digits.length()){
            res.add(buffer.toString());
        }else{
            char digit = digits.charAt(index);
            String strs = map.get(digit);


            //这里的循环表示拿到该字符串后要从第一个字符开始使用，用第一个之后就去第二层拿第二个字符串
            for(int i=0; i<strs.length(); i++){
                buffer.append(strs.charAt(i));
                dfs(index+1, res, digits, buffer);
                buffer.deleteCharAt(index);
            }
        }
    }
}
