package 动态规划.test;

public class RecursionTest {


    //    阶乘问题
    public static int factorial(int n) {

        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
