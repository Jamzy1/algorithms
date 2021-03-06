package 单调栈;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 0、1矩阵中的最大1矩阵
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class LeetCode85 {

    public int maximalRectangle(char[][] matrix) {
        //先求每个点向左衍生的矩阵，单行矩阵
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[n];

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;

    }

}

