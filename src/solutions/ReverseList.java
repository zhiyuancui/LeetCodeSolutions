/**
 * Reverse a singly linked list.
 */
package solutions;

import util.ListNode;


public class ReverseList {
	public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        while( cur != null )
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
