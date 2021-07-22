package solutions;

import util.RandomListNode;

/**
 * 138 Copy List with Random Pointer
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        
        if( head == null )
        {
            return head;
        }   
        
        //insert nodes
        RandomListNode cur = head;
        
        while( cur != null )
        {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        
        //Copy random List
        cur = head;
        RandomListNode copy = cur.next;
        
        while( copy != null && cur != null )
        {
            copy.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
            if( copy.next != null ){
            copy = copy.next.next;
            }
        }
        
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
    
      //remove old nodes
      //recover list
        cur = head;
        copy = dummy;
        while( cur != null && copy != null ) {
            copy.next = cur.next;
            cur.next = copy.next.next;
            cur = cur.next;
            copy = copy.next;
        }
        
        return dummy.next;
    }
    
}
