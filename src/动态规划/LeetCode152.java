package 动态规划;


/**
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 动态规划
 * 默认一路向后乘，遇到负数 最大最小交换 全程都维护一个全局max
 */
public class LeetCode152 {
    public int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
