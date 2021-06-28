package 树;


/**
 * 返回一颗完全二叉树的结点个数。小于O(n)，即不能遍历，遍历时严格的O(n)
 *
 * 思路：递归实现
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(Node node, int level, int h) {
//        当前结点的层数等于最左树的深度，直接返回1
        if (level == h) {
            return 1;
        }
//        如果当前结点的右子树的深度等于最左数的深度，说明左子树是一颗满二叉树
        if (mostLeftLevel(node.right, level + 1) == h) {
//            直接返回左子树＋继递归右子树
//            1 << (h - l) = 2^(h-1)
            return (1 << (h - level)) + bs(node.right, level + 1, h);
//            如果左没满，则返回右子树＋左继续递归
        } else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

//    最左树的深度
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
