package 回溯.岛屿;

/**
 * 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 */
public class LeetCodes79 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        //用于存放该格子是否被遍历过
        boolean[][] visited = new boolean[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                //从i,j开始能否拼成0到word最后的字符串
                boolean flag = check(board, visited, i, j, word, 0);
                if(flag) return true;
            }
        }
        return false;

    }
    boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int begin){
        if(board[i][j] != word.charAt(begin)){
            return false;
        }else if(begin == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[][] tmp = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        boolean result = false;
        for(int[] cur : tmp){
            int newi = i+cur[0];
            int newj = j+cur[1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if(!visited[newi][newj]){
                    boolean flag = check(board, visited, newi, newj, word, begin+1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
