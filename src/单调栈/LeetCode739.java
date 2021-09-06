package 单调栈;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈   栈里都是有顺序的    求左右离该位置最近且大于他的位置
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        for (int i=0; i<len; i++){
            int tem = temperatures[i];
            //当遇到前面有小的的时候，两个坐标相减
            while (!stack.isEmpty() && tem>stack.peek()){
                int preIndex = stack.pop();
                res[preIndex] = i-preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
