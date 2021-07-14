package 动态规划.guigu;


//迷宫回溯问题
//最短路径问题
public class MiGong {

    public static void main(String[] args) {

//        迷宫地图
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);

        System.out.println("路径");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


    /**
     *
     * @param map 迷宫地图
     * @param i 出发点横坐标
     * @param j 出发点纵坐标
     * @return
     * 1->墙，，2->通路，，3->该点走过，但走不通
     */
    public static boolean setWay(int[][] map,int i,int j){

//        如果走到终点，直接返回
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){  //如果该点没被走过

                map[i][j]=2;    //先假定该点能走，然后走这个点的周围

                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else{
//                    说明走不通是死路
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }
}
