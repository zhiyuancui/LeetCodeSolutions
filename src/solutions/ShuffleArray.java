package solutions;

import java.util.Random;

public class ShuffleArray {

	private int[] copy;
    private Random random;
    
    public ShuffleArray(int[] nums) {
        copy = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            copy[i] = nums[i];
        }
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copy;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if( copy == null ) return null;
        int[] res = copy.clone();
        for(int i=0; i < res.length; i++ ) {
        	
            int index = random.nextInt(i+1);
            int t = res[ index ];
            res[ index ] = res[ i ];
            res[i] = t;
        }
        
        return res;
    }
}
