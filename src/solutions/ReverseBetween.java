package solutions;

import util.ListNode;

/**
 * 92. Reverse Linked List II
 */
public class ReverseBetween {

	public ListNode reverseBetween(ListNode head, int left, int right) {
        if( head == null || head.next == null ){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        for(int i = 0; i < left - 1; i++ ){
            if( prev == null ){
                return null;
            }
            prev = prev.next;
        }
        
        ListNode tail = prev.next;
        for(int i = left; i < right; i++){
            ListNode cur = tail.next;
            tail.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
        }
        
        return dummy.next;
    }
}