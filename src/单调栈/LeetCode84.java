package 单调栈;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中的最大矩形
 *https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 单调栈
 */
public class LeetCode84 {

    public int largesRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int res = 0;
        //在左右加两个哨兵，比原数组所有数都要小,减少后面操作的判断
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);
        for (int i = 0; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}
