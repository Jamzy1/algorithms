package leetCode;


/**
 * 二维数组的查找(暴力解法 O(nm))
 *
 * 思路二(O(n+m))：观察数组，抛弃左上和右下两个极端点！！！！从右上遍历，一次可排除一行或者一列
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class LeetCodeOffer04 {


    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[] left={0,0};
        int[] right={matrix.length-1,matrix[0].length-1};
        int target=20;
        LeetCodeOffer04 leetCodeOffer04 = new LeetCodeOffer04();
        System.out.println(leetCodeOffer04.findNumberIn2DArray2(matrix,target));

    }

//    插入查找，数组长度为1时有bug。。。。
    public boolean findNumberIn2DArray(int[][] matrix, int[] left, int[] right, int target) {

        int x1=left[0],y1=left[1];
        int x2=right[0],y2=right[1];

        if (matrix.length==0||matrix[0].length==0||target < matrix[x1][y1]||target>matrix[x2][y2]) {
            return false;
        }

        int x=x1+(x2-x1)*(target-matrix[x1][y1])/(matrix[x2][y2]-matrix[x1][y1]);
        int y=y1+(y2-y1)*(target-matrix[x1][y1])/(matrix[x2][y2]-matrix[x1][y1]);

        int[] mid={x,y};
        int[] mid1={x-1,y-1};
        int[] mid2={x+1,y+1};

        int midValue=matrix[x][y];

        if (target<midValue){
            return findNumberIn2DArray(matrix,left,mid1,target);
        }else if (target>midValue){
           return findNumberIn2DArray(matrix,mid2,right,target);
        }else {
            return true;
        }


    }

//    思路二
    public boolean findNumberIn2DArray2(int[][] matrix,int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


}
