package 分治_二分;

/**
 * 比某个数num小于放左边，等于放中间，大于放右边
 *
 * 思路：设置一个小于和一个大于的区域，其实就是两个指针l、r，在设置一个指针p用于遍历
 *
 * 遍历过程遇到小于num的，将该数与l指针的下一位交换，然后l++，p++
 * 遇到大于num的，将该数与r后一位交换，然后r--，同时p不变，继续比较
 */

public class NetherlandsFlag {

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    public static int[] partition(int[] arr, int l, int r, int p) {

//        l、r是范围；less和more是指针
        int less = l - 1;
        int more = r + 1;
//        一直遍历到循环指针和右指针相遇
        while (l < more) {

            if (arr[l] < p) {
//                l小于的话交换完继续走
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
//                大于的交换完还要比较
                swap(arr, --more, l);
            } else {
//                等于的话不变
                l++;
            }
        }

//        返回等于区域的左右两个下标
        return new int[] { less + 1, more - 1 };
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
