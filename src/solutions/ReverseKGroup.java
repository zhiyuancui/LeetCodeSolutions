package solutions;

import util.ListNode;

public class ReverseKGroup {

public ListNode reverseKGroup(ListNode head, int k) {
        
        
        if( head == null || head.next == null || k <= 1 )
        {
            return head;
        }
        
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode end = head;
        ListNode prev = dummy;
        
        while( end != null )
        {
            for(int i = 1; i < k; i++)
            {
                end = end.next;
                if( end == null )
                {
                    break;
                }
            }
            
            if( end == null )
            {
                break;
            }
            
            prev = reverse(prev, end);
            end = prev.next;
        }
        
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end)
    {
        ListNode tail = end.next;
        ListNode cur = begin.next.next;
        ListNode prev = begin.next;
        while( cur != tail )
        {
            prev.next = cur.next;
            cur.next = begin.next;
            begin.next = cur;
            cur = prev.next;
        }
        
        return prev;
    }
    
    public static void main(String[] args)
    {
    	ReverseKGroup r = new ReverseKGroup();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	r.reverseKGroup(head, 2);
    }
}
