package 动态规划;


/**
 * 假设所有牛都是母牛，有n只牛，每年都会生一只牛，新生的牛要三年后才会生，牛不会死，求m年后牛的数量
 * <p>
 * F(n)=F(n-1)+F(n-3)   今年的牛等于 上一年的牛 加上 三年前的牛生下来的新牛(也就是三年前🐂的数量)
 */
public class Cow {

    public static void main(String[] args) {
        System.out.println(process(4, 9));
    }

    //    刚开始有4头牛，5年后有多少头
    public static int process(int n, int m) {
//        前四年只有老牛在生牛
        if (m <= 4) {
            return n;
        }
        return process(n, m - 1) + process(n, m - 3);
    }

}
