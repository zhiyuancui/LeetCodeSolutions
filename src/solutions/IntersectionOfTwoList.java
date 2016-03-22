package solutions;

import util.ListNode;

public class IntersectionOfTwoList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while( curA != null ){
            lenA++;
            curA = curA.next;
        }
        
         while( curB != null ){
            lenB++;
            curB = curB.next;
        }
        
        curA = headA;
        curB = headB;
        if( lenA > lenB ){
            int diff = lenA - lenB;
            curA = headA;
            while( diff > 0 ){
                curA = curA.next;
                diff--;
            }
            
        }else{
            int diff = lenB - lenA;
            curB = headB;
            while( diff > 0 ){
                curB = curB.next;
                diff--;
            }
        }
        
        while( curA != null && curB != null )
        {
            if( curA == curB ){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        
        return null;
    }
}
