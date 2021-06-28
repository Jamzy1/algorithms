package 哈希表;


import java.util.HashSet;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        int len = nums.length;
        if (len == 0) return res;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for(int num : nums){
            if (!set.contains(num - 1)) {
                int longCur = 1;
                while(set.contains(num+1)){
                    num++;
                    longCur++;
                }
                res = Math.max(res, longCur);
            }
        }
        return res;
    }
}
