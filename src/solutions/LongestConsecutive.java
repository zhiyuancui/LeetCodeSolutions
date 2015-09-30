package solutions;

import java.util.HashSet;

public class LongestConsecutive {

	
public int longestConsecutive(int[] nums) {
        
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        HashSet<Integer> numbers = new HashSet<Integer>();
        
        for(int i : nums)
        {
            numbers.add(i);
        }
        
        int len = 0;
        
        for(int i : nums )
        {
            if( numbers.contains(i) )
            {
                numbers.remove(i);
                int left = i - 1;
                while( numbers.contains( left) )
                {
                    numbers.remove( left );
                    left--;
                }
                
                int right = i + 1;
                while( numbers.contains(right) )
                {
                    numbers.remove(right);
                    right++;
                }
                
                
                len = Math.max(len, right - left - 1);
            }   
        }
        
        return len;
    }
}
