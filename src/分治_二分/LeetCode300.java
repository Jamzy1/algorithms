package 分治_二分;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 数组中的最长递增子序列
 * 可以用动归或者二分
 */
public class LeetCode300 {

    //动归解法
    public int lengthOfLIS(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



    //贪心+二分
    // tails[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
    //例如 [1,5,3]][1,5,3]]， 遍历到元素 55 时，长度为 22 的子序列尾部元素值为 55；当遍历到元素 33 时，尾部元素值应更新至 33，因为 33 遇到比它大的数字的几率更大
    public int lengthOfLIS2(int[] nums){
        //一定是一个递增数组、所以才能使用二分
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums){
            //这个res也是tails的长度，当res加一也就说明num比前面所有都大，直接加后面
            //否则就是进行替换
            int i = 0, j = res;
            while (i < j){
                int m = (i+j)/2;
                if (tails[m] < num) i = m+1;
                else j = m;
            }
            //每次num都会是tails的最后一个元素
            tails[i] = num;
            //说明num比所有的tails[i]都要大，所以序列变长 答案加一
            if (res == j) res++;
        }
        return res;
    }
}
