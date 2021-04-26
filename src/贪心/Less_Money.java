package 贪心;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 哈夫曼编码
 * 一个数组[10,20,30],将该数组分为3份，每次要花费所分数组的金额。
 * 第一次分为10和50:花费60，第二次将50分为20和30：花费50。
 *
 * 思路：把所有元素看成一棵树的叶子节点，两叶子节点合并(相加)成一个新结点，最终所有非叶子节点相加就是代价
 * 求解顺序是从底往上，实际分组是从上往底
 *
 */
public class Less_Money {

    public static int lessMoney(int[] arr) {
//        先将所有数据入队，优先级队列（堆）
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;

        while (pQ.size() > 1) {
//            两个最小的相加
            cur = pQ.poll() + pQ.poll();
//            累加结果
            sum += cur;
//            结果入队
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; // < 0  o1 < o2  负数
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // <   o2 < o1
        }

    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }

    }
}
