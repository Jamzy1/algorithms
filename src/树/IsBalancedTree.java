package 树;


/**
 * 判断一棵树是否是平衡二叉树：左子树和右子树的高度差小于等于1
 *
 * 递归实现
 */
public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

//    最后只返回是否是平衡二叉树，但递归过程还要记录树的高度
    public static boolean isBalance(Node head) {

//        表示是否是平衡二叉树,用数组才能进行参数传递
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

//    递归方法、会返回以head为头的树的高度
    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
//        左递归得到左子树的高度,level每次加一就是在算树的高度了
        int lH = getHeight(head.left, level + 1, res);
//        其左子树已经不是平衡二叉树了，直接返回高度
        if (!res[0]) {
            return level;
        }

//        右递归得到右子树的高度
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
//        如果左右高度大于1，不是平衡二叉树
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
