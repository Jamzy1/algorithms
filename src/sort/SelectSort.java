package sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序o(n^2)====8万个数据大概4秒
public class SelectSort {

    public static void main(String[] args) {
//        int[] a = {101, 119, 34, 1};
//        selectSort(a);

        int[] b = new int[80000];
        for (int i = 0; i < 80000; i++) {
            b[i]=(int)(Math.random()*8000000);
        }

//        测试排序时间

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(b);

        Date dat2 = new Date();
        String date2Str = simpleDateFormat.format(dat2);
        System.out.println("排序后的时间是=" + date2Str);



    }

//    选择排序 -> 选一个最小的和第一个交换，然后再 选一个最小的和第二个交换。。。。。。
    public static void selectSort(int[] arr) {

//        进行的每一轮循环
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];

//          每一轮循环中的小循环
            for (int j = i + 1; j < arr.length; j++) {

//                比较并让两个指针指到小的位置
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }

            }

//            如果指针改变，则进行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第" + (i + 1) + "轮后");
//            System.out.println(Arrays.toString(arr));

        }


    }
}
