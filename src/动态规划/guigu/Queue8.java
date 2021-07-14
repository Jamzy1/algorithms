package 动态规划.guigu;


/**
 *
 */
public class Queue8 {

    static int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法",count);
        System.out.printf("一共判断%d次",judgeCount);

    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
//            将皇后n放第一列
            array[n] = i;

//            判断是否冲突，不冲突就下一个，冲突就for循环到第二列
            if (judge(n)){
                check(n+1);
            }
        }
    }


    //    检查第n个皇后是否和前面的冲突

    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {

        judgeCount++;
        for (int i = 0; i < n; i++) {


//          1~n表示第几个皇后，也就是第几行
//          array[1]~array[n]表示第n个皇后在第几列
//          行的差的绝对值 和 列的差的绝对值相同就是在同一个斜线

//            array[i]==array[n]判断第n个皇后是否和前面的第n-1个皇后在同一列
//            Math.abs(n - i) == Math.abs(array[n] - array[i])判断第n个皇后是否和第i个皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //    输出皇后摆放的位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
