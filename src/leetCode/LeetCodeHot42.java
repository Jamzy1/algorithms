package leetCode;

/**
 * 接雨水：https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class LeetCodeHot42 {

    // 方法一：动态规划
    int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        //  两个动态规划数组
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        //  初始化首尾
        left_max[0] = height[0];
        right_max[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }


    //  双指针法
    int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                ++left;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                --right;
            }
        }
        return ans;
    }
}
