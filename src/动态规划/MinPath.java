package 动态规划;


/**
 *
 * 最小路径和，从一个二维表的(i,j)到(0,0),每一步都只能走左或者上，路径和等于各个点的值相加
 */
public class MinPath {

    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

//    暴力递归写法、会重复计算 (相同点的方法每调用一次就会重复计算一次)
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
//        如果已经在(0,0)位置
        if (i == 0 && j == 0) {
            return res;
        }
//        如果在第一行
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
//        如果在第一列
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
//        每一步都走 左 或者 上 的最小一路(是 左 到(0,0)的最小一路，和 上 到(0,0)的最小一路;这就是递归)
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

//    动规版本（每个点只会计算一次，因为已经记录下来了，下次要用直接在dp表里面拿）
    public static int minPath2(int[][] m) {

        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
//        新建一个状态表
        int[][] dp = new int[row][col];
//        确定base case,第一行和第一列
        dp[0][0] = m[0][0];

//        确定第一行所有到(0,0)的路径
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }

//        确定第一列所有到(0,0)的路径
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

//                上一个点的最小加上本身
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
//        返回最后一点
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }

}
