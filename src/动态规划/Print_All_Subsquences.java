package 动态规划;


/**
 * 打印一个字符串的全部子序列，包括空字符串
 * 子序列：可以不用连续
 *
 * 思路：穷举每个位置的所有情况，先从第一个位置开始
 */
public class Print_All_Subsquences {

    public static void main(String[] args) {

        char[] str={'a','b','c'};
//        一共有三个位置，刚开始从0个开始，字符串也为空
        printAllSub(str,0,"");

    }

    /**
     *
     * @param str 字符串
     * @param i 从第几个位置开始
     * @param res 上一层给来的字符串
     */
    public static void printAllSub(char[] str,int i,String res){
//        如果开始的位置已经是最后了，直接返回
        if (i==str.length){
            System.out.println(res);
            return;
        }
//        下一个位置i+1有两种情况，可以不加，也可以加
        printAllSub(str,i+1,res);
        printAllSub(str,i+1,res+String.valueOf(str[i]));

    }
}
