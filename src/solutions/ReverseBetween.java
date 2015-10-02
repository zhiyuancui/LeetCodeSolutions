package solutions;

import util.ListNode;

public class ReverseBetween {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        
        
        if( head == null || m >= n )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode begin = dummy;
        
        for(int i = 0; i < m - 1; i++ )
        {
            if( begin == null )
            {
                return null;
            }
            begin = begin.next;
        }
        
        ListNode prev = begin.next;
        
        ListNode cur = prev.next;
        for(int i = m; i < n; i++)
        {
            prev.next = cur.next;
            cur.next = begin.next;
            begin.next = cur;
            cur = prev.next;
        }
        
        return dummy.next;
    }
}
