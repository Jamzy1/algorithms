package search;


/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 0 1 1 2 3 5 8
 * 0 1 2 3 4 5 6
 */
public class LeetCodeOffer10_1 {

    public static void main(String[] args) {

    }

    //动态规划
    public int fib(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 1000000007;
        }
        return nums[n];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
     * 当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
     * 当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
     *
     * @param n
     * @return
     */
//    动态规划，不构造数组
    public int numWays(int n) {
        if (n==0||n==1){
            return 1;
        }
        int pre=1,cur=2;
        for (int i = 3; i < n; i++) {
            int temp=(pre+cur)%1000000007;
            pre=cur;
            cur=temp;
        }
        return cur;

    }


}
