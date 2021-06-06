package 回溯.排列组合;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 */
public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bfs(0,nums,res,new ArrayList<Integer>());
        return res;
    }
    private void bfs(int begin, int[] nums, List<List<Integer>> res, List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=begin; i<nums.length; i++){
            if(i>begin && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            bfs(i+1,nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
