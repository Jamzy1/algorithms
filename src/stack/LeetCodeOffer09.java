package stack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * <p>
 * 思路：用两个栈维护一个队列，一个用于入队，一个用于出队，
 * 入队：直接加入栈1
 * 出队：判断栈二是否有，如果无，将栈一（如果栈一没有，直接返回-1）的元素出栈后全部加入栈二，如果有，直接返回一个栈顶，
 */
public class LeetCodeOffer09 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());

    }
}

class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}

/**
 * 栈和队列的互换
 */
class StackConvertQueue{


    /**
     * 双栈实现队列，和上题一样
     */
    public static class TwoStacksQueue {

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

//        构造方法
        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
//    push
        public void push(int pushInt) {
            stackPush.push(pushInt);
        }
//        poll
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

//    双队列实现栈
    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

//        构造方法
        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
//            将queue poll剩下一个，然后将这个返回
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
//            将两个队列互换，多的那个永远是入栈的队列
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }
}
