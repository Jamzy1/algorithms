package leetCode;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class LeetCode1122 {

    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        LeetCode1122 leetCode1122 = new LeetCode1122();
        System.out.println(Arrays.toString(leetCode1122.relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

//        拿到arr1中最大的数
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }

//        将arr1中元素出现的个数记录在frequency对应下标中(桶排序)
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }

//        将相同的录入ans数组
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;

            }
//            录完将其置为0
            frequency[x] = 0;
        }

//        将arr2中没有的也从大到小录入到ans中(通排序)
        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }

        }
        return ans;
    }


}
