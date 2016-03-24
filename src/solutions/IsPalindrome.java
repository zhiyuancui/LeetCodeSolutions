package solutions;

import util.ListNode;

public class IsPalindrome {
    
	/**
	 * Determine whether an integer is a palindrome. 
	 * Do this without extra space.
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
        
		
        if( x < 0 )
        {
            return false;
        }
        
        if( x < 10 )
        {
            return true;
        }
        
        String number = Integer.toString(x);
        
        int front = 0;
        int end = number.length() - 1;
        
        while( front < end )
        {
            if( number.charAt(front) != number.charAt(end) )
            {
                return false;
            }
            else
            {
                front++;
                end--;
            }
            
        }
        
        return true;
    }
	
	
	/**
	 * Palindrome Linked List
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null ){
            return true;
        }
        
        ListNode cur = head;
        int len = 0;
        while( cur != null ){
            len++;
            cur = cur.next;
        }
        
        int mid = len / 2;
        
        cur = head;
        ListNode newHead = null;
        for(int i = 0; i < mid; i++){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead =cur;
            cur = next;
        }
        
        if( len % 2 == 1 ){
            cur = cur.next;
        }
         
        for(int i = 0; i < mid; i++ ){
            if( newHead.val != cur.val ){
                return false;
            }
            newHead = newHead.next;
            cur = cur.next;
        }
        return true;
    }
}
