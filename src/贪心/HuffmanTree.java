package 贪心;

import java.util.ArrayList;
import java.util.Collections;




/**
 * 构建哈夫曼树
 * 取两个最小结点为左右子树、相加的结点为他们的根节点，然后继续放入，继续遍历
 */
public class HuffmanTree {

    public static void main(String[] args) {

    }

    /**
     *
     * @param arr   数组表示所有结点的值
     * @return
     */
    public static Node createHuffmanTree(int[] arr) {

//        将树结点存放在Array
        ArrayList<Node> nodes = new ArrayList<>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {

//            对结点排序
            Collections.sort(nodes);

//            取前两个最小结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node partner=new Node(leftNode.value+rightNode.value);

            partner.left=leftNode;
            partner.right=rightNode;

//            构建好的父节点放到Array后面
            nodes.add(partner);

//            将构建好的结点删掉
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }

        return nodes.get(0);

    }
    static class Node implements Comparable<Node> {

        int value;
        Node left;
        Node right;

        //    前序遍历
        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {

//        表示从小到大排
            return this.value - o.value;
        }
    }


}



