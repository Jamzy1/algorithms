package 队列;


//利用取模操作实现队列的复用
//加是在数组的后面加，取是在数组的前面取
public class CircleArray {
    private int maxSize;    //表示数组最大容量
    private int front;      //队列头,指向队列的第一个数据
    private int rear;       //队列尾，指向最后一个位置的再后一个位置
    private int[] arr;      //该数据用于存放数据，模拟队列

    //        队列构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;     //指向队列头的前一个位置
        rear = 0;      //指向队列的最后一个数据
    }

    //        判断队列是否满
    //        当还剩一个空间时我们就约定队列已经满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
//        将rear后移,考虑取模,要是刚好满则rear会等于0
        rear = (rear + 1) % maxSize;
    }

    //        获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        //维护好front变量就行，后面能直接覆盖删除的元素
        front = (front + 1) % maxSize;
        return value;
    }

    //        显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //    返回当前队列的有校数据个数
    //    中间加maxSize是防止rear在front的前面
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //        返回队列头数据，不取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }


}
