package stack;


import java.util.Stack;


/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 思路：设置一个栈，模拟过程，将pushed入栈的同时判断栈顶是否和popped的第一个相等，相等则pop栈，最后判断栈是否为空
 */
public class LeetCodeOffer31 {

    public static void main(String[] args) {

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int index=0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty()&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
