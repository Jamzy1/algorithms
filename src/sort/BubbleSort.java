package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序o(n^2)=====8万个数据需要大概10秒钟
public class BubbleSort {

    public static void main(String[] args) {

        int[] a = {3, 9, -1, 10, -2};

        int[] b = new int[80000];
        for (int i = 0; i < 80000; i++) {
            b[i]=(int)(Math.random()*8000000);
        }

//        测试排序时间
        /*
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        bubbleSort1(b);

        Date dat2 = new Date();
        String date2Str = simpleDateFormat.format(dat2);
        System.out.println("排序后的时间是=" + date2Str);
*/
    }


    //    冒泡 —> 一趟确定一个数，一趟要遍历所有还没确定的数(length-1-i),一共要遍历length-1趟，每次遍历把不符合规则的交换位置
    public static void bubbleSort1(int[] arr) {

        int temp = 0;//临时变量，用于交换
        boolean flag = false;//用于标记一趟下来是否有发生交换，如果没有直接停止遍历
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {//这一趟排序中没有交换
                break;
            } else {
                flag = false;//重置flag
            }
//            System.out.println("第" + (i + 1) + "躺后的数组");
//            System.out.println(Arrays.toString(arr));

        }

    }
}
