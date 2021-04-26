package stack.guigu;

//  用数组模拟栈
public class ArrayStack {

    private int maxSize;    //栈的大小
    private int[] stack;    //数组，模拟栈
    private int top = -1;   //栈顶，初始化为-1

    //    构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //    栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //    栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //    入栈
    public void push(int value) {

        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //    出栈
    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //    遍历栈
    public void list() {

        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}
