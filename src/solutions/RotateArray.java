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
    
    public static void main(String[] args){
    	RotateArray r = new RotateArray();
    	int[] nums = {1,2,3,4,5,6,7};
    	r.rotate(nums, 3);
    }
}
