package solutions;

import util.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
	     
        if( head == null || head.next == null )
        {
            return head;
        }   
        
        ListNode dummy = new ListNode(0);
        
        while( head != null )
        {
            ListNode cur = dummy;
            while( cur.next != null && cur.next.val < head.val )
            {
                cur = cur.next;
            }
            ListNode next = head.next;
            head.next = cur.next;
            cur.next = head;
            head = next;
            
        }
        
        return dummy.next;
    }
}
