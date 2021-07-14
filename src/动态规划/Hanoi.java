package 动态规划;

/**
 * 汉诺塔问题：三个柱子，一叠从大到小的饼，要移到另一根柱子
 */
public class Hanoi {

//    zuo上的n个饼移到you上
    public static void process(int n,String zuo,String you,String help){
//        只有1个饼，直接移
        if (n==1){
            System.out.println("move 1 from "+zuo+" to "+you);
        }else {
//            先将n-1个饼移到help
            process(n-1,zuo,help,you);
//            再将最后一个移到you
            System.out.println("move "+n+" from "+zuo+" to "+you);
//            最后将n-1个饼移回you
            process(n-1,help,you,zuo);
        }
    }
    public static void main(String[] args) {
        process(3,"zuo","you","help");
    }
}
