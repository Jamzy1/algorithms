package 动态规划;


/**
 * 给一个数组和一个数，如果数组的任意数的和等于这个数，返回true
 * <p>
 * https://blog.csdn.net/pcwl1206/article/details/89476568?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=163b319e-bdd1-442a-9820-7016cc85ba9d&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
 * <p>
 * 思路：每个数都有两种状态——选和不选
 */
public class Money_Problem {

    /**
     * 递归暴力：每种情况都列举，每个数字都有两种状态，从第一个数字向后走，列出一棵二叉树，每一层一个数
     *
     * @param arr 数组
     * @param aim 数
     * @return
     */
    public static boolean money1(int[] arr, int aim) {
        return process1(arr, 0, 0, aim);
    }

    /**
     * @param arr
     * @param i   已加数的下标
     * @param sum 已加数的和
     * @param aim
     * @return
     */
    public static boolean process1(int[] arr, int i, int sum, int aim) {

//        来到最后这个位置时，是否有一个sum等于aim
        if (i == arr.length) {
            return sum == aim;
        }
        // 数组中下标为 i 的数可以要也可以不要，有两种选择
        // 最后有一个等于aim，一路往上都返回true
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    //    动规版本(更好理解)
    public static boolean money2(int[] arr, int aim) {

//        状态表存放Boolean值，状态表的某一列的值，表示该列代表的数加到最后一列代表的数有无可能加到aim
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];

//        状态表上aim的那一列全为true
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
//                先将该值右边的值赋给该值（一行一行的赋值。刚开始的初始列是aim）
                dp[i][j] = dp[i + 1][j];

//                再根据条件矫正，如果要矫正的列(j + arr[i]) 在aim右边，则不用矫正
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }

//        状态表上的(0,0)表示整个数组上的所有数都能参加累加
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
