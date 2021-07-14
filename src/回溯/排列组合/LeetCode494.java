package 回溯.排列组合;

/**
 * https://leetcode-cn.com/problems/target-sum/
 */
public class LeetCode494 {
    private int ans;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        back(0,nums,target,0);
        return ans;
    }
    private void back(int begin,int[] nums,int target, int res){
        if(begin == nums.length){
            if(res == target){
                ans++;
            }
            return;
        }
        //begin只会向前走
        back(begin+1, nums, target, res+nums[begin]);
        back(begin+1, nums, target, res-nums[begin]);
    }

}
