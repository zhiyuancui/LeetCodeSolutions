package solutions;

import util.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
        if( head == null || head.next == null ){
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = slow;
        slow = slow.next;
        fast.next = null;
        
        //reserve the last part
        ListNode prev = null;
        ListNode cur = slow;
        while( cur != null ){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        ListNode rightHead = prev;
        cur = head;
        while( cur != null && rightHead != null ){
        		ListNode next = cur.next;
            ListNode rightNext = rightHead.next;
            rightHead.next = cur.next;
            cur.next = rightHead;
            cur = next;
            rightHead = rightNext;
        }
    }
}
