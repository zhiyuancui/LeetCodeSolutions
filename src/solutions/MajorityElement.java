package solutions;

/**
 * 169 Majority Element
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int count = 0;
        int majority = 0;
        
        for(int i : nums )
        {
            if( count == 0 )
            {
                majority = i;
            }
            
            if( majority == i )
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        
        return majority;
    }
}
