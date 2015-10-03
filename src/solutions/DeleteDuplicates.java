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
	

	/**
	 * Given a sorted linked list, 
	 * delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list.
	 * For example,
	 * Given 1->2->3->3->4->4->5, return 1->2->5.
	 * Given 1->1->1->2->3, return 2->3.
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
        
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        boolean duplicate = false;
        while( cur != null && cur.next != null )
        {
            duplicate = false;
            while( cur.next != null && cur.val == cur.next.val )
            {
                duplicate = true;
                cur = cur.next;
            }
            
            if( duplicate )
            {
                cur = cur.next;
                continue;
            }
            
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        
        
        prev.next = cur;
        
        return dummy.next;
    }
}
