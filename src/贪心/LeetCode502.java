package 贪心;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本
 *
 *
 * 输入: k=2, W=0, 利润：Profits=[1,2,3], 启动资金：Capital=[0,1,1].
 *
 * 输出: 4
 *
 * 解释:
 * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 *
 *
 */
public class LeetCode502 {

//    一个结点表示一个项目的利润和启动资金
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }


//    低资金比较器
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

//    高收益比较器
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        结点数组
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

//        小根堆，启动资金小的在上面
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
//        大根堆，收益大的在上面
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
//        先把所有项目放小根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
//        依次做项目、最多做k个
        for (int i = 0; i < k; i++) {
//            把启动资金小于现有资金的项目放大根堆(按收益大小放)
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
//            如果大根堆没有，直接返回
            if (maxProfitQ.isEmpty()) {
                return W;
            }
//            否则就一个一个做
            W += maxProfitQ.poll().p;
        }
        return W;
    }

}
