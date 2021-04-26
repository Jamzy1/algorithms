package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {2,6,4,89,67,2434,456,1,5567,242,666};
        radixSort(arr);

    }

//    基数排序(个位、十位、百位分别进行桶排序)，消耗arr.length*11*4字节的空间
//    经典的空间换时间算法、稳定的排序算法
    public static void radixSort(int[] arr) {

//        求出数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

//        最大数的位数
        int maxLength = (max + "").length();

//        二维数组表示10个桶
        int[][] bucket = new int[10][arr.length];

//        一维数组表示每个桶里的数
        int[] bucketElementCount = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {

                int digitOfElement = arr[j] / n % 10;

//                将该数放到第 bucket[digitOfElement] 个桶的第 bucketElementCount[digitOfElement] 个位置
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];

//                放完之后将该位置加一，下次还要放该桶就直接放下一位了
                bucketElementCount[digitOfElement]++;

            }

            int index = 0;

//            将桶里的数据按顺序遍历到arr中
            for (int j = 0; j < bucketElementCount.length; j++) {

                if (bucketElementCount[j] != 0) {

                    for (int k = 0; k < bucketElementCount[j]; k++) {

                        arr[index++] = bucket[j][k];

                    }
                }

//                清空bucketElementCount数组
                bucketElementCount[j] = 0;

            }

            System.out.println(Arrays.toString(arr));

        }


    }
}
