package 分治_二分;

import java.util.Arrays;


/**
 * 归并排序(分治思想)
 *
 *
 * 思路：递归、先将元素分解，一直对半分，然后合并的时候按大小合并
 * (左边有序、右边有序，合并有序，用双指针合并)
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //    分解
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {

            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }


//    合并

    /**
     * @param arr   原始数组
     * @param left  左边起始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中间数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {

//            将两边元素有序(比较大小)合并到temp
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;

        }

//        将剩余的元素全部复制到temp
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

//        将temp元素拷贝到arr
        t = 0;
        int tempLeft = left;//为了不改变原有参数

        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
}
