package 回溯.岛屿;

/*
 * 回溯模板题：字母表中匹配出word
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 *
 * */
public class LeetCodeOffer12 {

    public boolean exist(char[][] board, String word) {
//        转为数组，一个一个当作word的第一个字母进行遍历
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

//    i、j定位字母在board中的位置，k定位words中的位置
    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
//        先判断是否越界
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != words[k]) {
            return false;
        }
//        k是word中的下标
        if (k == words.length - 1) return true;

//        如果当前字母匹配成功则把字符改为0表示已经被匹配过
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);

//        匹配结束把字母还原,还原时word[k]一定等于board[i][j],因为如果不等于就直接返回false了board[i][j]也不会被赋值为0
        board[i][j] = words[k];
        return res;
    }

}
