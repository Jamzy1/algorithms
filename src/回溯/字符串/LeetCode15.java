package 回溯.字符串;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 不是回溯，但是这个不允许出现重复三元组的操作和回溯中的部分处理有点像
 * https://leetcode-cn.com/problems/3sum/
 */
public class LeetCode15 {

    public List<List<Integer>> threeSun(int[] sums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (sums == null || sums.length < 3) return ans;
        Arrays.sort(sums);
        for (int i = 0; i < sums.length; i++) {
            //排序后如果该数及后面的都大于0，则不存在
            if (sums[i] > 0) break;
            //处理相同的三元组
            if (i > 0 && sums[i] == sums[i - 1]) continue;
            int left = i + 1;
            int right = sums.length - 1;
            while (left < right) {
                int sum = sums[i] + sums[left] + sums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(sums[i], sums[left], sums[right]));
                    while (left < right && sums[left] == sums[left + 1]) left++;
                    while (left < right && sums[right] == sums[right - 1])
                        right--;
                    left++;
                    right--;
                }else if (sum<0){
                    left++;
                }else if (sum>0){
                    right--;
                }
            }
        }
        return ans;
    }
}
