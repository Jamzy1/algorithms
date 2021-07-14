package 动态规划;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1~n的结点能组成多少不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 左子树和右子树就是动规能复用的部分
 */
public class LeetCode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
