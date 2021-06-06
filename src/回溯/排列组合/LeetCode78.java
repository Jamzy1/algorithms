package 回溯.排列组合;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 子集
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sub(0, nums, res, new ArrayList<Integer>());
        return res;
    }
    private void sub(int begin, int[] nums, List<List<Integer>> res, List<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for (int i = begin; i < nums.length; i++) {
            tmp.add(nums[i]);
            sub(i+1,nums,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
