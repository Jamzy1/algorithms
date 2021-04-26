package 分治_二分;


import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 8, 8, 8, 8, 13, 45, 69, 97};

//        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));

        System.out.println(binarySearch2(arr, 0, arr.length - 1, 8));

    }


    //    二分查找只适用于有序的数组
//    一直比较中间数，然后对半分缩小查找范围
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
//            右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
//            左递归
            return binarySearch(arr, left, mid, findVal);
        } else {
            return mid;
        }
    }

    /**
     * 二分法查找数组中某个数的  所有下标  (不止出现一次)
     * 思路：找到该数后分别向左和向右遍历找出相同的数，记录其下标
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
//            右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
//            左递归
            return binarySearch2(arr, left, mid, findVal);
        } else {

            List<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;

            while (true) {

                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }

            resIndexList.add(mid);
            temp = mid + 1;

            while (true) {

                if (temp >= arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }

            return resIndexList;
        }
    }

}
