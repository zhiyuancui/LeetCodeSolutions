package solutions;

import java.util.HashMap;

public class ContainsNearbyDuplicate {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for( int i = 0; i < nums.length; i++ )
        {
            if( map.containsKey( nums[i] ) )
            {
                int index = map.get( nums[i] );
                if( ( i - index ) <= k )
                {
                    return true;
                }
                else
                {
                    map.put( nums[i], i );
                }
            }
            else
            {
                map.put( nums[i], i );
            }
        }
        
        return false;
    }
	
}
