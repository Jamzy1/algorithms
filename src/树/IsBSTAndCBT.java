package 树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 一、判断一棵树是否是搜索二叉树：左小于根小于右，中序遍历是顺序的
 *    中序遍历该数，如果拿到的数都比上一个大，就是搜索二叉树
 *
 *
 * 二、判断一棵树是否是完全二叉树：最后的叶子结点从左到右
 *
 *
 */
public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head!=null){
            Stack<Node> stack = new Stack<>();
//            存放上一个结点的值
            int temp=Integer.MIN_VALUE;
            while (!stack.isEmpty()||head!=null){

                if (head!=null){
                    stack.push(head);
                    head=head.left;
                }else {
                    head=stack.pop();
//                    如果小于上一个数 直接返回false
                    if (head.value<temp){
                        return false;
                    }
                    temp=head.value;
                    head=head.right;
                }
            }
        }
        return true;

    }

//    判断一棵树是否是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
//        判断是否进入叶子状态，全局只有一个，即接下来的结点都不能有叶子节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

//            开启叶子状态时，不能有一个叶子节点了 或者 左没有 右有
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
//            没开启叶子状态，哪边有就加哪边，都有就都加
            if (l != null) {
                queue.offer(l);
            }
//            没开启叶子状态，哪边有就加哪边
            if (r != null) {
                queue.offer(r);
//                如果两边都没有则开启叶子状态，即head是叶子了
            } else {
                leaf = true;
            }
        }
//        如果每个结点都没有返回false，则返回true
        return true;
    }

    // for test -- print 树
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
