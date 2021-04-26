package linkedList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 思路一：从尾到头，反转，第一个想到用！！栈！！
 * 思路二：用递归，回溯输出
 */
public class LeetCodeOffer06 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        LeetCodeOffer06 leetCodeOffer06 = new LeetCodeOffer06();
        System.out.println(Arrays.toString(leetCodeOffer06.reversePrint2(listNode1)));

    }

    public int[] reversePrint(ListNode head){
        if (head==null){
            return null;
        }
//        创建一个栈，用于存放链表结点
        Stack<ListNode> stack = new Stack<>();
//        临时结点，用于遍历链表
        ListNode temp=head;
//        遍历链表
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
//        创建数组，将栈存入数组，并返回
        int[] res = new int[stack.size()];
        int i=0;
        while (!stack.empty()){
            res[i++]=stack.pop().val;
        }

        return res;

    }

//    用递归
    ArrayList<Integer> list = new ArrayList<>();
    public int[] reversePrint2(ListNode head){

        recur(head);

        int[] res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    void recur(ListNode head){
        if (head==null){
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
