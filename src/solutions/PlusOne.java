package solutions;

import util.ListNode;

/**
 * 66 Plus One
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
        
        int[] result = new int[ digits.length + 1 ];
        
        if( digits == null || digits.length == 0 )
        {
            return result;
        }
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i-- )
        {
            result[ i + 1 ] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = result[i+1];
        }
        
        if( carry != 0 )
        {
            result[0] = carry;
            return result;
        }
        
        return digits;
    }
	
	 public ListNode plusOne(ListNode head) {
	       ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode i = dummy;
	        ListNode j = dummy;
	        
	        while (j.next != null) {
	            j = j.next;
	            if (j.val != 9) {
	                i = j;
	            }
	        }
	        
	        if (j.val != 9) {
	            j.val++;
	        } else {
	            i.val++;
	            i = i.next;
	            while (i != null) {
	                i.val = 0;
	                i = i.next;
	            }
	        }
	        
	        if (dummy.val == 0) {
	            return dummy.next;
	        }
	        
	        return dummy;
	    }
	
	
}
