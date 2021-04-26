package 分治_二分;


/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * 思路一：分治思想，归并排序，实现归并排序的同时计算逆序对，排序后计算会更轻松
 */
public class LeetCodeOffer51 {

    public static void main(String[] args) {

        int[] nums={7,5,6,4};

        LeetCodeOffer51 leetCodeOffer51 = new LeetCodeOffer51();
        System.out.println(leetCodeOffer51.reversePairs(nums));


    }

    //    输入数组返回逆序对
    public int reversePairs(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return 0;
        }
//        复制原数组，不破坏原来数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
//        辅助数组
        int[] temp = new int[len];
        return merge(copy, 0, len - 1, temp);
    }

    public int merge(int[] nums, int left, int right, int[] temp) {

        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;

        int mergeLeft = merge(nums, left, mid, temp);

        int mergeRight = merge(nums, mid + 1, right, temp);
//        如果前半部分的最大小于后半部分的最小，说明没有逆序对，直接返回 前部分自己产生的逆序对 加 后部分自己的产生逆序对
        if (nums[mid] <= nums[mid + 1]) {
            return mergeLeft + mergeRight;
        }
//        计算 前部分 与 后部分 共同产生的逆序对
        int mergeMid = mergeSort(nums, left, mid, right, temp);

        return mergeLeft + mergeMid + mergeRight;

    }

//    将两个有序的数组合并成一个有序的
    public int mergeSort(int[] nums, int left, int mid, int right, int[] temp) {

//        复制一个，操作新的数组，最后排好的结果再旧数组
        for (int i = left; i <= right; i++) {
            temp[i]=nums[i];
        }
//        左指针
        int i=left;
//        右指针
        int j=mid+1;
//        计算逆序对的个数
        int count=0;
//        遍历整个数组
        for (int k = left; k <=right; k++) {
//            如果i排完了，将j一个一个排到nums
            if (i==mid+1){
                nums[k]=temp[j];
                j++;
//                如果j排完了
            }else if (j==right+1){
                nums[k]=temp[i];
                i++;
            }else if (temp[i]<=temp[j]){
                nums[k]=temp[i];
                i++;
            }else {
                nums[k]=temp[j];
                j++;
//                每次后面有一个小于前面的，则前面数组的后半部分都要大于后面这个数
                count+=mid+1-i;
            }
            
        }
        return count;

    }

}
