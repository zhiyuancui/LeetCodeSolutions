package solutions;

import util.ListNode;

/**
 * 19 Remove Nth Node From End of List
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if( head == null )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //get len
        int len = 0;
        ListNode cur = head;
        while( cur != null )
        {
            cur = cur.next;
            len++;
        }
        
        head = dummy;
        for( int i = 0; i < len -n ; i++ )
        {
            head = head.next;
        }
        
        head.next = head.next.next;
        
        return dummy.next;
    }
}
