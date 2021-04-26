package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        shellSort(arr);

        int[] b = new int[80000];
        for (int i = 0; i < 80000; i++) {
            b[i]=(int)(Math.random()*8000000);
        }

//        测试排序时间

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort2(b);

        Date dat2 = new Date();
        String date2Str = simpleDateFormat.format(dat2);
        System.out.println("排序后的时间是=" + date2Str);


    }

//    分组、然后交换
//    交换法实现希尔排序 -> 效率变慢，比原先的插入排序慢
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;

//        分组，确定增量gap，并逐渐缩小gap
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

//            遍历被gap分出来的组
            for (int i = gap; i < arr.length; i++) {

//                遍历组里的元素
                for (int j = i - gap; j >= 0; j -= gap) {

//                    如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }

            }

            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }

    }

//    对交换式的排序进行优化 -> 移位式
//    对插入排序的优化，效率高,一秒不到
    public static void shellSort2(int[] arr){


//        分组确定增量
        for (int gap = arr.length/2; gap >0; gap/=2) {

//            遍历组
            for (int i = gap; i <arr.length ; i++) {

                int j=i;
                int temp = arr[j];

//                当组中后面的数小于前面的数时
                if (arr[j]<arr[j-gap]){

//                    后移大的数，再比较，直到退出循环再交换
                    while (j-gap>=0&&temp<arr[j-gap]){

                        arr[j]=arr[j-gap];
                        j-=gap;
                    }

//                    交换
                    arr[j]=temp;
                }

            }
            //System.out.println(Arrays.toString(arr));

        }

    }
}
