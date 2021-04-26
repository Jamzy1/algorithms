package 递归_动规;


/**
 * 打印一个字符串的全排列
 * 回溯算法(穷举遍历)
 */
public class Print_All_Permutations {

    public static void main(String[] args) {

        String str="123";
        printAllPermutations1(str);

    }

    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] chs,int i){
        if (i==chs.length){
            System.out.println(String.valueOf(chs));
        }
//        i>chs.length时进不去这个循环
        for (int j = i; j < chs.length; j++) {
//            两个位置交换
            swap(chs,i,j);
//            进入下一层，层数为3时打印
            process1(chs,i+1);
//            从下一次出来要交换回来，即回溯，回到原来的状态，然后将i与j的下一个交换
            swap(chs,i,j);
        }


    }
//    交换两个元素
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
