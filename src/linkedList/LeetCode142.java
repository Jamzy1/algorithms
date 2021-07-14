package linkedList;


/**
 * 寻找环形链表的入环结点
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针判断是否有环、数学推导得到入环点，相遇点到入环点等于head到入环点
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        if(head == null) return null;
        ListNode fast = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }
            if(fast==slow){
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
        return null;
    }


}
