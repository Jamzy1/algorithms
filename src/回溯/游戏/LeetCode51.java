package 回溯.游戏;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/solution/
 * n皇后
 */
public class LeetCode51 {

    public List<List<String>> solveQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //数组，用来表示一张答案中每一行中q的位置，用charge方法转换
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        //三个集合用来判断同一列、同一斜行没有其他q
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(res, queens, n, 0, columns, diagonals, diagonals2);
        return res;
    }

    private void backtrack(List<List<String>> res, int[] queens, int n,
                           int row, Set<Integer> columns,
                           Set<Integer> diagonals, Set<Integer> diagonals2) {
        //当到达最后一行时
        if (row == n) {
            List<String> board = change(queens, n);
            res.add(board);
        } else {
            //如果还没到最后一行，则从第一列开始遍历，在这一行添加一个q
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal = row - i;
                if (diagonals.contains(diagonal)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                //找到之后把该位置坐标记录在queens上
                queens[row] = i;
                //记录第i列已经有了
                columns.add(i);
                diagonals.add(diagonal);
                diagonals2.add(diagonal2);
                backtrack(res, queens, n, row+1, columns, diagonals, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals.remove(diagonal);
                diagonals2.remove(diagonal2);
            }
        }

    }


    private List<String> change(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
