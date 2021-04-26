package stack;

import java.util.Stack;

/**
 * 单调栈=====矩阵
 *
 * 计算一个由0、1组成的矩阵中最大的且全部由1组成的子矩阵的面积
 *
 */
public class MaximalRectangle {

    public static int MaxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int MaxArea = 0;  //放最大面积
        int[] height = new int[map[0].length];    //放矩阵的每一行

//        遍历数组
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                该行如果是0，直接赋值，如果是1，就等于上一行的数加一
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }

            MaxArea = Math.max(MaxRecFromBottom(height), MaxArea);
        }

        return MaxArea;

    }

    //    求一个由数组表示的直方图中最大的矩阵的面积,用单调栈实现
    public static int MaxRecFromBottom(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
//       全局变量，存面积
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
//            因为要求一个数左右两边比它小且离他最近的数
//            栈从顶到底是从大到小，如果要入一个小的数，先判断如何将大的数出栈，出栈的同时统计其左右，并计算面积
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
//                结算过程
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
//                底乘高
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }

//        遍历完成如果栈中还剩余元素，继续统计
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;


    }

}
