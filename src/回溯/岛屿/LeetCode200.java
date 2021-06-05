package 回溯.岛屿;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * 第一个模板直接四次递归把上下左右的位置lou进去，第二个搞循环
 */
public class LeetCode200 {

    //  第一次的模板
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int n=grid.length,m=grid[0].length,res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    res+=1;
                    infect(grid,i,j);
                }
            }
        }
        return res;
    }
    void infect(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        infect(grid,i-1,j);
        infect(grid,i+1,j);
        infect(grid,i,j-1);
        infect(grid,i,j+1);
    }







    //  第二次使用的模板，略显冗余
    private int[][] tmp = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands2(char[][] grid) {
        int h = grid.length, w = grid[0].length;
        int res = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] == '1'){
                    res++;
                    infect2(grid, i, j);
                }

            }
        }
        return res;
    }
    void infect2(char[][] grid, int i, int j){
        for(int[] cur : tmp){
            int newi = i + cur[0], newj = j + cur[1];
            if(newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length){
                if(grid[newi][newj] == '1'){
                    grid[newi][newj] = '2';
                    infect2(grid, newi, newj);
                }
            }
        }
    }
}
