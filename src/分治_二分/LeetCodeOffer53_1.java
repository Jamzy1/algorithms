package 分治_二分;


/**
 * 返回有序数组中某个数出现的次数
 */
public class LeetCodeOffer53_1 {

    int cur = 0;  //计数器，用于二分过程中计算相等数的个数

    public int Search(int[] nums, int target) {

//        排除特殊情况
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
        helper(nums, 0, nums.length - 1, target);
        return cur;
    }

    void helper(int[] nums, int left, int right, int target) {
//        控制边界，不然会无限递归，栈溢出
        if (left <= right) {
            int mid = left + (right - left) / 2;
//            当相等时，加一，并且两边都需要递归
            if (nums[mid] == target) {
                cur++;
                helper(nums, left, mid - 1, target);
                helper(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                helper(nums, left, mid - 1, target);
            } else if (nums[mid] < target) {
                helper(nums, mid + 1, right, target);
            }
        }
    }


    public int Search2(int[] nums,int tar){
        return helper2(nums,tar)-helper2(nums, tar-1);
    }

//    返回每个相同的数的最后一个
    int helper2(int[] nums,int tar){
        int i=0,j=nums.length-1;
        while (i<=j){
            int m=i+(j-i)/2;
//            把等于的情况包括在大于的情况，返回的就是最后一个
            if (nums[m]<=tar){
                i=m+1;
            }else {
                j=m-1;
            }
        }
        return i;
    }



    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 9, 9, 9, 45};
        LeetCodeOffer53_1 leetCodeOffer53_1 = new LeetCodeOffer53_1();
        System.out.println(leetCodeOffer53_1.Search2(nums, 9));
    }
}
