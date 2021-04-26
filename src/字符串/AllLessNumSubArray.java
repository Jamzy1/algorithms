package 字符串;


import java.util.LinkedList;

/**
 * 双端队列
 *
 * 求一个数组中所有连续子数组的个数，要求这些子数组的max-min <= sum
 *
 * 思路：如果一个子数组达标，那么其内部所有的子数组都达标(内部的子数组max只会变小，min只会变大)
 *      如果一个子数组不达标，那么其往外扩的数组都不达标(max只会变大，min只会变小)
 */
public class AllLessNumSubArray {

    public static int getSum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

//        两个队列，分别用于得到最大值和最小值，存的只是数组的下标
        LinkedList<Integer> qMin = new LinkedList<Integer>();
        LinkedList<Integer> qMax = new LinkedList<Integer>();

        int L = 0;
        int R = 0;
        int res = 0;


//        时间复杂度O(n);不是L每走一步 R就要循环一次。L每走一步，R就会往后走若干步
//        两个都只会往后走
        while (L < arr.length) {
//            L固定，R向后走
            while (R < arr.length) {
//                更新qMin,最后一个大于要加入的数=>淘汰,加入的数一定是队列中最大的数
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);
//                更新qMax
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);
//                如果不符合条件，退出当前循环
                if (arr[qMax.peekFirst()]-arr[qMin.peekFirst()]>num){
                    break;
                }
                R++;
            }
//            判断下标是否过期，L要向后走了，两个队列也要先更新
            if (qMin.peekFirst()==L){
                qMin.pollFirst();
            }
            if (qMax.peekFirst()==L){
                qMax.pollFirst();
            }
//            将符合结果的子数组数量加入res
            res+=R-L;
//            L向后走
            L++;
        }
        return res;
    }
}
