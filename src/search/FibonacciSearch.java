package search;

import java.util.Arrays;


//基于二分思想，斐波那契数列确定mid
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 89));

    }

    //    通过该方法创建斐波那契数列
    public static int[] fib() {

        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int[] f = fib();
        int mid = 0;
        int k = 0;
        while (high > f[k] - 1) {
            k++;
        }

//        将数组arr用0补全到长度为f[k]-1
        int[] temp = Arrays.copyOf(arr, f[k]);

//        将后面的0变为arr[high]
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

//        开始执行算法
        while (low <= high) {

            mid=low+f[k-1]-1;

            if (value < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }

        }

        return -1;

    }


}
