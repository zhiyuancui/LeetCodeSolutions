package solutions;

import util.ListNode;

/**
 * 203 Remove Linked List Elements
 */
public class RemoveElement {

	public ListNode removeElements(ListNode head, int val) {

        if( head == null )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        while( prev != null )
        {
            
            while( prev.next != null && prev.next.val == val )
            {
                prev.next = prev.next.next;
            }
            
            prev = prev.next;
        }
        
        return dummy.next;
    }
}
