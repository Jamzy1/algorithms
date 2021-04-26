package 字符串;


/**
 * 数组中第k小的数
 */
public class BFPRT2 {

    public static void main(String[] args) {

    }

    public static int getK(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return -1;
        }
        return getKth(nums,0,nums.length-1,k-1);
    }

    public static int getKth(int[] nums,int left,int right,int k){
        return 0;
    }

}
