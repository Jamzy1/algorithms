package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

//   大概2秒
    public static void main(String[] args) {

//        int[] a = {101,34,119,1};
//        insertSort(a);

        int[] b = new int[80000];
        for (int i = 0; i < 80000; i++) {
            b[i]=(int)(Math.random()*8000000);
        }

//        测试排序时间

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(b);

        Date dat2 = new Date();
        String date2Str = simpleDateFormat.format(dat2);
        System.out.println("排序后的时间是=" + date2Str);

    }

//    插入排序 -> 将无序的数一个一个插入到有序的数
    public static void insertSort(int[] arr) {

        int insertVal =0;
        int insertIndex =0;

//        从1开始(第0个是默认的有序的)，一共遍历length-1趟
        for (int i = 1; i < arr.length; i++) {

//          每次需要从无序插入有序的数(也就是无序的第一个数)
            insertVal = arr[i];
            insertIndex = i - 1;

//            当insertIndex(下标)还没越界,待插入数还小于有序的最后一个时(有序最后一个也就是有序最大的数)
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

//                将有序且大于插入数的向后移一位（给插入数腾出一个空位）
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

//            跳出循环后直接插入
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第"+i+"轮插入");
//            System.out.println(Arrays.toString(arr));
        }

    }
}
