package queue;

//有缺点
//数组实现的队列，使用一次后就不能再使用
// 存取过后由于指针问题即使是空也不能再存
public class ArrayQueue {

    private int maxSize;    //表示数组最大容量
    private int front;      //队列头
    private int rear;       //队列尾
    private int[] arr;      //该数据用于存放数据，模拟队列

    //        队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;     //指向队列头的前一个位置
        rear = -1;      //指向队列的最后一个数据
    }

    //        判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //        判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //        添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //        获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //        显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //        返回队列头数据，不取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }



}