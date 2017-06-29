package solutions;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        if( nums == null || nums.length < 2 || k < 1){
            return;
        }
        
        int n = nums.length;
        
        k = k % n;
        reverse(nums,0,n-k);
        reverse(nums,n-k,n);
        reverse(nums,0,n);
    }
    
    private void reverse(int[] nums, int left, int right){
        while( left < right ){
            int temp = nums[left];
            right--;
            nums[ left ] = nums[ right ];
            nums[ right ] = temp;
            left++;
        }
    }
   
}
