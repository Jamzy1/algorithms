package 回溯.岛屿;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class LeetCode130 {

    public void solve(char[][] board) {
        int h = board.length, w = board[0].length;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if((i == 0 || i == h-1 || j == 0 || j == w-1) && board[i][j] == 'O'){
                    infect(board, i, j);
                    board[i][j] = 'K';
                }
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'K'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    void infect(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'K';
        infect(board, i-1, j);
        infect(board, i+1, j);
        infect(board, i, j-1);
        infect(board, i, j+1);
    }
}
