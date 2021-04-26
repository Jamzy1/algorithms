package sort;


//堆排序O(nlogn)

import java.util.Arrays;

/**
 * 堆这个结构是一颗完全二叉树，在堆排序中虽然有用到但是实际上是一个数组，树结构是我们脑补出来的。
 *
 * 完全二叉树的叶子结点比非叶子结点多一个
 *
 * 大顶堆：任何一颗子树的头部都是这颗子树最大的数  (堆里的数都是最小的数)
 * 小顶堆：任何一颗子树的头部都是这颗子树最小的数  (堆里的数都是最大的数)
 * 1).将无序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆(升序==>大顶堆，降序==>小顶堆);
 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * 3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
 * 直到整个序列有序。
 */
public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {2, 6, 4, 87, 32, 756, 689, 32, -66, -1};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 将一个数组(二叉树)调整为大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子结点在数组中的位置
     * @param length 数组剩余的长度，会越来越短
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];    //大的换到上面
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;          //小的换下来

    }

    public static int[] heapSort(int[] arr) {

        int temp = 0;

//        构造大顶堆(从第一个非叶子结点开始。从下换到上，换到上面的时候可能会破坏下面，所以i--再次循环)
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

//        交换首位
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
//            交换完重新调整堆
            adjustHeap(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }








    //    堆的再理解
    public static void HeapSort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }
//        将数组中的元素一个一个插入堆，形成大顶堆
        for (int i = 0; i < nums.length; i++) {
            HeapInsert(nums, i);
        }
        int size = nums.length;
//        交换堆顶和最后一个元素
        swap(nums, 0, --size);
//        交换完进行判断调整
        while (size > 0) {
            HeapIfy(nums, 0, size);
            swap(nums, 0, --size);
        }
    }

    //    将元素插入大顶堆
    public static void HeapInsert(int[] nums, int index) {
//        大于父节点，交换，交换完来到父节点，一直向上调整
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    //    将交换后的堆重新调整
    public static void HeapIfy(int[] nums, int index, int size) {
        int left = index * 2 + 1;
//        size不会被调整
        while (left < size) {
//            取左右最大
            int largest = left + 1 < size && nums[left] < nums[left + 1] ? left + 1 : left;
//            取父和左右的最大的结点下标
            largest=nums[index]>nums[largest]?index:largest;
            if (largest==index){
                break;
            }
//            否则交换，并且index下移，一直往下调整
            swap(nums,index,largest);
            index=largest;
            left=index*+1;
        }

    }

    //    交换两个元素
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}
