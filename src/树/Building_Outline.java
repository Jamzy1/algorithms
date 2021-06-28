package 树;

import java.util.*;


/**
 * https://www.lintcode.com/problem/131/ 大楼轮廓问题
 */
public class Building_Outline {


    public static class Node {
//        上还是下
        public boolean isUp;
//        位置
        public int posi;
//        高度
        public int h;

        public Node(boolean bORe, int position, int height) {
            isUp = bORe;
            posi = position;
            h = height;
        }
    }

//    比较器
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {

//            位置前的排前面
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
//            如果同一位置有两个方向，规定向上的排前面
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {

//        将原来的大楼信息分解，一栋有左右两个边界，故长度为原来的两倍
        Node[] nodes = new Node[buildings.length * 2];

//        分解过程
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
//        分完进行排序
        Arrays.sort(nodes, new NodeComparator());

//        k:某一个高度   v:这个高度出现的次数
        TreeMap<Integer, Integer> htMap = new TreeMap<>();

//        记录当前位置、和该位置的最大高度
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();

//        遍历信息数组
        for (int i = 0; i < nodes.length; i++) {

//            判断是否是向上：加一个高度
            if (nodes[i].isUp) {
//                判断是否是第一次出现
                if (!htMap.containsKey(nodes[i].h)) {
//                    如果是 次数为1
                    htMap.put(nodes[i].h, 1);
                } else {
//                    如果不是 次数为上一次的加一
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
//                如果是下，且map出现过
                if (htMap.containsKey(nodes[i].h)) {
//                    出现过一次，直接变为0，移除
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
//                        否则减一
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
//            用pmMap记录信息
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
//        用pmMap生成轮廓
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;

//        遍历pmMap，因为有序，，，所以位置是从左到右，得到每个位置的最大高度
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();

            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }
}
