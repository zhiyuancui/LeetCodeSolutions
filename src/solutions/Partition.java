package solutions;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class Partition {

	public ListNode partition(ListNode head, int x) {
	     
	     if( head == null || head.next == null )
	     {
	         return head;
	     }   
	     
	     ListNode left = new ListNode(0);
	     ListNode right = new ListNode(0);
	     
	     ListNode l = left;
	     ListNode r = right;
	     
	     while( head != null )
	     {
	         if( head.val >= x )
	         {
	             r.next = head;
	             r = r.next;
	         }
	         else
	         {
	             l.next = head;
	             l = l.next;
	         }
	         
	         head = head.next;
	     }
	     
	     r.next = null;
	     l.next = right.next;
	     
	     return left.next;
	    }
	
	/**
	 * Palindrome Partitioning
	 * Given a string s, partition s such that 
	 * every substring of the partition is a palindrome.
	 * Return all possible palindrome partitioning of s.
	 * For example, given s = "aab",
	 * Return
	 * [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 * ]
	 */
	public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        if( s == null || s.length() == 0 )
        {
            return result;
        }
        
        List<String> solution = new ArrayList<String>();
        
        builder(result, solution, 0, s.length(), s);
        
        return result;
    }
    
    private void builder(List<List<String>> result, List<String> solution, int start, int len, String s)
    {
        if( start == len )
        {
            result.add( new ArrayList(solution) );
        }
        
        for(int i = start + 1; i <= len; i++)
        {
            String seg = s.substring(start,i);
            if( validPalindrome(seg) )
            {
                solution.add(seg);
                builder(result, solution, i, len, s);
            }
        }
        
    }
    
    private boolean validPalindrome(String s)
    {
        int start = 0;
        int end  = s.length() - 1;
        
        while( start < end )
        {
            if( s.charAt( start ) != s.charAt(end) )
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        
        return true;
        
    }
    
    
    public static void main(String[] args)
    {
    	Partition p = new Partition();
    	p.partition("a");
    }
}
