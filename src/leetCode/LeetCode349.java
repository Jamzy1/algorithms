package leetCode;


import sort.HeapSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 计算两个无序数组的交集
 * 解法一：先将两个数组存入哈希表，然后遍历哈希表解决，用O(1)判断一个元素是否有在哈希表内，降低时间复杂度O(m+n)
 * <p>
 * 解法二：将两个数组排序，然后用双指针比较
 */
public class LeetCode349 {

    public static void main(String[] args) {
        int[] num1 = {2, 2, 5, 67, 32, 32, 1};
        int[] num2 = {55, 2, 4, 67, 32, 1, 99};
        System.out.println(Arrays.toString(solution(num1, num2)));

    }

    /**
     * 解法一
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        return setIntersection(set1, set2);

    }

    public static int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {

//        交换位置，小的在前面
        if (set1.size() > set2.size()) {
            return setIntersection(set2, set1);
        }

        HashSet<Integer> integerHashSet = new HashSet<>();

//        循环判断
        for (int num : set1) {
            if (set2.contains(num)) {
                integerHashSet.add(num);
            }
        }

//        最后把答案哈希表转换为数组
        int[] res = new int[integerHashSet.size()];
        int index = 0;
        for (int num : integerHashSet) {
            res[index++] = num;
        }
        return res;
    }

    /**
     * 解法二
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {

        HeapSort heapSort = new HeapSort();

        int[] nums3 = heapSort.heapSort(nums1);
        int[] nums4 = heapSort.heapSort(nums2);

        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        int[] res = new int[nums1.length+nums2.length];

        while (temp1 < nums3.length && temp2 < nums4.length) {
            int num1 = nums3[temp1], num2 = nums4[temp2];
            if (num1 == num2) {
                if (temp==0||res[temp-1]!=num1){
                    res[temp++]=num1;
                }
                temp1++;
                temp2++;
            }else if (num1>num2){
                temp2++;
            }else {
                temp1++;
            }
        }
        return Arrays.copyOfRange(res,0,temp);

    }


}
