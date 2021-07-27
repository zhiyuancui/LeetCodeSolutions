package solutions;

import util.ListNode;

/**
 * 21 Merge Two Sorted Lists
 */
public class MergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null && l2 == null ) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while( l1 != null || l2 != null ) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            
            if( v1 < v2 ) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
