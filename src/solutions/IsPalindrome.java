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
	
	public boolean isPalindrome2(int x) {
        if( x < 0 ){
            return false;
        }
        
        if( x < 10  )
        {
            return true;
        }
        
        
        int num = x;
        int time = 1;
        while( x >= 10 ){
            x = x/ 10;
            time *= 10;
        }
        
        x = num;
        
        while( x > 0 ){
            int right = x % 10;
            x = x/ 10;
            
            int left = num / time;
            num = num % time;
            time = time / 10;
            
            if( left != right ){
                return false;
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
	
	
	/**
	 * Valid Palindrome
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
        if( s== null || s.length() == 0 ){
            return true;
        }
        
        s = s.toLowerCase();
        
        int len = s.length();
        int front = 0;
        int end = len - 1;
        
        while( front < end ){
            while( front < s.length() && !isLetter( s.charAt(front) ) ){
                front++;
            }
            
            if( front == s.length() ){
                return true;
            }
            
            while( end >= 0 && !isLetter( s.charAt(end) ) ){
                end--;
            }
            
            if(  s.charAt( front) != s.charAt(end) ){
               break;
            }else {
                front++;
                end--;
            }
        }
        
        return end <= front;
    }
    
    
    private boolean isLetter(Character c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
    /**
     * Valid Palindrome II
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if( s == null || s.length() == 0 ) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1 ;
        
        while( left < right ) {
            if( s.charAt(left) != s.charAt(right) ) {
                return isPalindrome(s, left +1 , right) || isPalindrome(s, left, right - 1 );
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome( String s, int left, int right ) {
        while( left < right ) {
            if( s.charAt(left) != s.charAt(right) ) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
	
}
