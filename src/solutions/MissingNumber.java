package solutions;

/**
 * 268 Missing Number
 */
public class MissingNumber {

	public int missingNumber2(int[] nums) {
	    int len = nums.length;
        int sum = (1+len)*len/ 2; //
        
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[ i ];
        }
        
        return sum;
	}
}
