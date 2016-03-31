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
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>( lists.length, new ListNodeComparator() );
    
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

    private class ListNodeComparator implements Comparator<ListNode>{
        public int compare(ListNode l1, ListNode l2){
            if( l1 == null ){
                return 1;
            }else if( l2 == null ){
                return 2;
            }else{
                return l1.val - l2.val;
            }
            
        }
    }
}
