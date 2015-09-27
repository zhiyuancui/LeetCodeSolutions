package solutions;

import util.ListNode;

public class DeleteDuplicates {

	
	/**
	 * Given a sorted linked list, 
	 * delete all duplicates such that 
	 * each element appear only once.
	 * For example,  Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while( fast != null )
        {
            if( slow.val == fast.val )
            {
                fast = fast.next;
                continue;
            }
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast;
        return dummy.next;
    }
}
