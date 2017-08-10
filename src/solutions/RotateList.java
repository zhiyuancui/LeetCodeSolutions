package solutions;

import util.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null || k == 0 ){
            return head;
        }
        
        int len = 0;
        ListNode cur = head;
        while( cur != null ){
            cur = cur.next;
            len++;
        }
        
        k = k % len;
        
        int shift = len - k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while( shift > 0 ){
            prev = prev.next;
            shift--;
        }
        
        ListNode head2 = dummy;
        while( k > 0 ){
            cur = prev.next;
            prev.next = prev.next.next;
            cur.next = head2.next;
            head2.next = cur;
            head2 = head2.next;
            k--;
        }
        
        return dummy.next;
    }
}
