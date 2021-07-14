package 单调栈;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
 * 方法一：动态规划
 * 方法二：单调栈
 * 方法三：双指针
 */
public class LeetCode42 {

    /**
     * 方法一：动态规划 O(n)  O(n)
     * 先找出每个点左边最大和右边最大的数，分别存再两个数组
     * 然后再遍历一遍数组，找出 左边最大 和 右边最大 的两个数中 小的那个 和自己相减
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        //构建数组
        left_max[0] = height[0];
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        //再次遍历并累加
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;

    }

    /**
     * 方法二：单调栈 O(n)  O(n)
     * 利用单调栈判断当前元素和栈顶元素的关系
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0, current = 0, len = height.length;
        Deque<Integer> stack = new LinkedList<>();
        while (current < len) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - top;
                int bun_height = Math.min(height[stack.peek()],
                        height[current]) - height[top];
                res += distance * bun_height;
            }
            stack.push(current++);
        }
        return res;
    }

    /**
     * 方法三：双指针 O(n)  O(1)
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            //哪边小维护哪边
            if (height[left] < height[right]) {
                if (height[left]>=left_max){
                    left_max=height[left];
                }else{
                    res+=(left_max-height[left]);
                }
                ++left;
            }else{
                if (height[right]>=right_max){
                    right_max=height[right];
                }else{
                    res+=(right_max-height[right]);
                }
                --right;
            }
        }
        return res;

    }
}
