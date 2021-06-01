package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import util.ListNode;

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0 ){
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>( lists.length, (a,b) -> a.val - b.val);
    
        for( ListNode list : lists ){
            if( list != null ){
                heap.offer( list );
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        while( !heap.isEmpty() ){
            ListNode cur = heap.poll();
            prev.next = cur;
            prev = prev.next;
            if( cur.next != null ){
                heap.offer( cur.next );
            }
        }
        
        return dummy.next;
    }
}
