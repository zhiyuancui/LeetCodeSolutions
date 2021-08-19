package solutions;

/**
 * 189 Rotate Array
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
	     
        if( nums == null || nums.length < 2 || k < 1){
            return;
        }
        
        int n = nums.length;
        
        k = k % n;
        
        swap(nums, 0, n -1);
        swap( nums, 0,k-1);
        swap(nums, k, n -1);            
    }
    
    private void swap(int[] nums, int left, int right ) {
        
        while( left < right ) {
            int temp = nums[ left ];
            nums[ left ] = nums[ right ];
            nums[ right ] = temp;
            left++;
            right--;
        }
    }
   
}
