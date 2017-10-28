package solutions;

import java.util.Arrays;

public class MissingNumber {
	
	public int missingNumber(int[] nums) {
        
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int[] temp = new int[ nums.length + 1];
        
        Arrays.fill(temp, -1);
        
        for( int i : nums )
        {
            temp[i] = i;
        }
        
        
        for(int i = 0; i < temp.length; i++)
        {
            if( temp[i] != i )
            {
                return i;
            }
        }
        
        return 0;
    }
	
	public int missingNumber2(int[] nums) {
	    int len = nums.length;
        int sum = (1+len)*len/ 2; //
        
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[ i ];
        }
        
        return sum;
	}
}
