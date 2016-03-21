package solutions;

import util.ListNode;

public class LinkedListCycle {
	public ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null ){
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while( fast != slow ){
            if( fast == null || fast.next == null ){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode point = head;
        
        while( point != slow){
            point = point.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
