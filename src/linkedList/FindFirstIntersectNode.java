package linkedList;


/**
 * 寻找两条链表第一个相交的点，链表可能有环
 *
 * 思路：两个都有环和两个都无环，(不可能出现一个有环一个无环的情况)
 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
//        判断有无环
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
//        两个都无
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
//        两个都有
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


//    先判断都有环还是都无环
    public static Node getLoopNode(Node head) {
//        结点数小于3，直接无环
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast

//        最后快慢指针会相遇，即有环
        while (n1 != n2) {
//        如果有尽头，返回null
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
//        两指针有可能是在环中相遇的
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
//        返回入环结点
        return n1;
    }

//    两条无环链表是否相交
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
//        尾不同直接返回
        if (cur1 != cur2) {
            return null;
        }
//        cur1指向长链表的头
        cur1 = n > 0 ? head1 : head2;
//        cur2指向短链表的头
        cur2 = cur1 == head1 ? head2 : head1;
//        n为长度差
        n = Math.abs(n);
//        cur1走掉不可能相交的部分
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
//        下面一起走，相等就开始相交
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

//    有环的情况，两条链表一定是同一个环，入环结点可能不同而已
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
//        相同的入环结点，情况和无环一样
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
//            如果不是同一个入环结点
        } else {
            cur1 = loop1.next;
//            cur1在环上遍历，遇到loop1就返回
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
