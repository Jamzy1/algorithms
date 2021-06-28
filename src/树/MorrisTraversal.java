package 树;


/**
 * Morris遍历，时间复杂度O(n),空间复杂度O(1)的二叉树遍历方式
 *
 * 过程：1、cur为当前结点的引用；如果cur无左孩子，cur向右移动(cur=cur.right)====这一步的向右移就是回溯，此时右指针已经指向cur
 *      2、如果cur有左孩子，找到cur的左孩子上最右的结点，记为mostRight
 *           1、如果mostRight的右指针指向空，让其指向cur，然后cur向左移动(cur=cur.left)
 *           2、如果mostRight的右指针指向cur，让其指向空，然后cur向右移动
 *
 * 总结：有左子树的结点到达两次、没有左子树的到达一次，当第二次到达某个结点时，该结点的左子树已被遍历
 *      用当前节点的左子树上的最右结点是否指向cur判断是第几次到达当前节点
 */
public class MorrisTraversal {


//    递归遍历的过程每个结点都会遍历到三次，哪种顺序就看在那一次遍历打印
//    Morris遍历就是这个过程的优化
    public static void process(Node head) {
        if(head == null) {
            return;
        }
        // 1
        //System.out.println(head.value);
        process(head.left);
        // 2
        //System.out.println(head.value);
        process(head.right);
        // 3
        //System.out.println(head.value);
    }

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

//    中序遍历
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;    //来到的当前结点
        Node mostRight = null;      //当前节点左子树上最右的结点

        while (cur != null) {
            mostRight = cur.left;
//            如果有左孩子
            if (mostRight != null) {
//                找到当前节点左子树上最右的结点，赋给mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
//                如果等于空，则右指针指向cur，cur向左走
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
//                    如果是指向cur，则指回空
                } else {
                    mostRight.right = null;
                }
            }
//            如果没有左孩子(或者左子树都被处理完了)、就直接打印当前结点让后向右走====中序，左中右
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

//    morris前序，第一次来到该节点就打印
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
//                当前节点左子树上最右的结点 的 右指针指向空，代表第一次来这个结点，直接打印就是先序
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
//                如果没有左，直接打印当前结点
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

//    morris后序(左右中)
//    只考虑能第二次到达的结点，每次都 逆序 打印第二次到达的结点的右边界(最右的那一斜列)
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
//                    第二次到达该结点
                } else {
//                    将右指针指为空
                    cur2.right = null;
//                    逆序打印其右边界
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
//        最后再逆序打印整棵树的右边界
        printEdge(head);
        System.out.println();
    }

//    逆序打印，先将每个指针往上指(相当于链表逆转)，打印完再调回来
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    // for test -- print tree
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
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        printTree(head);

    }
}
