package stack.guigu;

//  用数组模拟栈实现计算器
public class ArrayStack2 {

    private int maxSize;    //栈的大小
    private int[] stack;    //数组，模拟栈
    private int top = -1;   //栈顶，初始化为-1

    //    构造器
    public ArrayStack2(int maxSize) {
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

//    取到栈顶元素的值
    public int peep(){
        return stack[top];
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

//    判断操作符优先级
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

//    判断是否为运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

//    计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;//存放计算结果
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }

}
