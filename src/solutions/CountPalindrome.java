package solutions;

import java.util.HashSet;
import java.util.Set;

public class CountPalindrome {

	public int longestPalindrome(String s) {
        if( s == null ){
        	return 0;
        }
        
        int len = s.length();
        if( len <= 1 ){
        	return len;
        }
        
        
        int count = 1;
        Set<String> set = new HashSet<String>();
        set.add(s.substring(0,1));
        for(int i = 1; i < len; i++){
        	
        	if( !set.contains( s.substring(i,i+1) ) )
        	{
        		count++;
        		set.add( s.substring(i,i+1) );
        	}
        	
        	int low = i -1; 
        	int high = i;
        	
        	//Find a palindrome string which is centered at i -1. length is even
        	while( low >= 0 && high < len && s.charAt(low) == s.charAt(high) ){
        		low--;
        		high++;
        		String seg = s.substring(low+1,high);
        		if( !set.contains(seg) ){
        			count++;
        			set.add(seg);
        		}
        	}
        	
        	//Find a palindrome string which is centered at i. length is odd
        	low = i - 1; high = i +1;
        	while( low >= 0 && high < len && s.charAt(low) == s.charAt(high) ){
        		low--;
        		high++;
        		String seg = s.substring(low+1,high);
        		if( !set.contains(seg) ){
        			count++;
        			set.add(seg);
        		}
        	}
       
        }
        System.out.println( count );
        return count;
        
    }
}
