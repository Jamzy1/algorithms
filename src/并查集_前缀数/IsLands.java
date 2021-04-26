package 并查集_前缀数;


/**
 * 判断一片海洋(0)中有多少块陆地(1),所有上下左右相连的算一个岛
 *
 * 常规做法:BFS
 *
 * 大数据作法(海洋极大时):多核多CPU,将海洋分割成若干块,分别用BFS做并给每一块陆地标号,
 * 然后用并查集合并不同块的边界(遍历边界、都是陆地则合并两块集合并且标同好)
 */
public class IsLands {

    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
//        遍历整个海洋
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                遇到一就加一并且从该点感染所有相连的一(改为2)
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
//        边界内
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
//        改为2
        m[i][j] = 2;
//        上下左右递归
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
