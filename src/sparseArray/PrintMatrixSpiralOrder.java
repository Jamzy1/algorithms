package sparseArray;


import java.util.Arrays;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(Arrays.toString(spiralOrder(matrix)));

    }

    public static int[] spiralOrder(int[][] matrix) {

        if(matrix.length==0){
            return new int[0];
        }
//        上下左右四个边界
        int left=0,right=matrix[0].length-1,top=0,bot=matrix.length-1,index=0;
        int[] res=new int[(right+1)*(bot+1)];

        while(true){
//            左到右一行
            for(int i=left;i<=right;i++){
                res[index++]=matrix[top][i];
            }
//            判断还有没有下一行
            if(++top>bot) break;
//            上到下一列
            for(int i=top;i<=bot;i++){
                res[index++]=matrix[i][right];
            }
//            判断还有没有列
            if(--right<left) break;
            for(int i=right;i>=left;i--){
                res[index++]=matrix[bot][i];
            }
            if(--bot<top) break;
            for(int i=bot;i>=top;i--){
                res[index++]=matrix[i][left];
            }
            if(++left>right) break;
        }
        return res;

    }






}
