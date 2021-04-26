package leetCode;


/**
 * 找出数组中所有元素的前面的符合某个条件的元素
 * <p>
 * i<j;nums[i]>2*nums[j]
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * <p>
 * 归并，分出来后每次都只需算后一个数组和和前一个数组产生的翻转对(一前一后)
 */
public class LeetCode493 {


    public static void main(String[] args) {

        int[] arr={1,3,2,3,1};
        LeetCode493 leetCode493 = new LeetCode493();
        System.out.println(leetCode493.reversePairs(arr));

    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            return reversePairsRecursive(nums, 0, nums.length - 1);
        }
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
//            左递归
            int n1 = reversePairsRecursive(nums, left, mid);
//            右递归
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

//            算前后产生
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }


            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ret;
        }

    }


}
