package leetCode;


import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 思路一(超时)：直接暴力解决(二重遍历数组)会超出时间限制
 * <p>
 * 思路二：一次遍历，没遇到的加入哈希表，遇到的加入失败，直接返回
 * <p>
 * 思路三：数组容量n，里面有n个数，如果没有重复则刚好时0~n-1;故可以遍历数组，原地交换
 */
public class LeetCodeOffer03 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        LeetCodeOffer03 leetCodeOffer03 = new LeetCodeOffer03();
        System.out.println(leetCodeOffer03.findRepeatNumber3(arr));

    }

    //    思路二，哈希表
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public int findRepeatNumber3(int[] nums) {
        int temp;//用于交换

//        循环数组
        for (int i = 0; i < nums.length; i++) {
//            和当前下标不一样时
            while (nums[i] != i){
//                如果和对应下标上的数一样，直接返回
                if (nums[i]==nums[nums[i]]){
                    return nums[i];
                }
//                不一样就交换
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }

        }
        return -1;
    }


}
