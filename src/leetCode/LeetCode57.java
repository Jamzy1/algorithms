package leetCode;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 将一个区间加入到一个区间集合，并合并成一个无相交的区间集合
 * <例题>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * <p>
 * 思路：用区间集合去和要插入的比较 (集合中的区间都是从小到大排好的)
 * 1、(无交集)如果遍历到的第一个区间就在newInterval的右边，则把插入区间加入、再把其他的全部加入区间
 * 2、(无交集)如果在插入的左边，则把遍历到的直接加入
 * 3、！！！如果和插入的有交集、则！更新！这个插入区间！！！
 */
public class LeetCode57 {

    public static void main(String[] args) {

        int[][] arr= {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] arr1={4,8};
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] res=leetCode57.insert(arr,arr1);
        for (int[] res1:res){
            System.out.println(Arrays.toString(res1));

        }


    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int x = newInterval[0];
        int y = newInterval[1];
//        标志位，判断插入区间是否已加入list
        Boolean flag = false;
        ArrayList<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {

//            在插入区间的右边
            if (interval[0] > y) {
//                在右边说明newInterval最小，要先加入
                if (!flag) {
                    list.add(new int[]{x, y});
                    flag = true;
                }
                list.add(interval);

//                在插入区间的左边
            } else if (interval[1] < x) {
                list.add(interval);
            } else {
                x = Math.min(interval[0], x);
                y = Math.max(interval[1], y);
            }
        }
        if (!flag) {
            list.add(new int[]{x, y});
        }


//        将list转换为数组
        int[][] res = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);

        }
        return res;


    }
}
