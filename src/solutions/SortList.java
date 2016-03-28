package solutions;

import util.ListNode;

/**
 * Merge Sort
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ){
            return head;
        }
        
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = slow;
        slow = slow.next;
        fast.next = null;
        
        ListNode l1 = sortList( head );
        ListNode l2 = sortList( slow );
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while( l1 != null || l2 != null ){
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            
            if( val1 <= val2 ){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            
            cur = cur.next;
        }
        
        return dummy.next;
        
    }
    
    public static void main(String[] args){
    	SortList s = new SortList();
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(4);
    	s.sortList(head);
    }
}
