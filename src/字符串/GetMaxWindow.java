package 字符串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 双端队列
 * <p>
 * 获得每个窗口的最大值,窗口会遍历数组
 * <p>
 * 思路：双端队列实现、窗口每次更新队列都会更新
 * <p>
 * 双端队列：从头到尾是从大到小有序的
 * <p>
 * 入队：如果队列不为空且最后一个小于即将要加进来的数，把最后一个弹出，直到遇到比arr[i]大的数
 */
public class GetMaxWindow {

    public static int[] getMaxWin(int[] arr, int w) {
        if (arr == null || w < 1 || w > arr.length) {
            return null;
        }

//        自带的双端队列，first是最大的数，last是最小的数
        LinkedList<Integer> qMax = new LinkedList<>();
//        存放答案
        int[] res = new int[arr.length - w + 1];
        int index = 0;
//        遍历数组
        for (int i = 0; i < arr.length; i++) {

//            如果队列不为空且最后一个小于即将要加进来的数，把最后一个弹出，直到遇到比arr[i]大的数
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);//只存下标
//            如果队列的第一个等于窗口最前面的数，则更新
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
//            窗口是否已经形成
            if (i > w - 1) {
//                将队列最大数放入答案
                res[index++] = qMax.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 7, 4, 32, 44, 86, 5};
        System.out.println(Arrays.toString(getMaxWin(arr, 3)));

    }

}
