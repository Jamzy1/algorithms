package 字符串;


/**
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 * 检查是否区域内所有整数都被覆盖
 * 暴力+优化
 * 排序
 * 差分数组
 */
public class LeetCode1893 {

    public boolean isCovered(int[][] ranges, int left, int right){
        //差分数组的长度ranges的范围
        int[] diff = new int[52];
        //构造差分数组
        for (int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]]++;
            diff[ranges[i][1]+1]--;
        }
        int[] sum = new int[52];
        for (int i = 1; i < 52; i++) {
            sum[i] = diff[i] + sum[i-1];
        }
        for (int i = left; i <= right ; i++) {
            if(sum[i] <= 0) return false;
        }
        return true;

    }
}
