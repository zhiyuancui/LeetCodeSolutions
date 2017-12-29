package solutions;

public class SortColor {

	public void sortColors(int[] nums) {
        
        if( nums == null || nums.length == 0 ){
            return;
        }
        
        int[] count = new int[3];
        
        for(int i : nums ){
            count[i]++;
        }
        
        int index =0;
        for(int i = 0; i < 3; i++){
            int times = count[i];
            for(int j = 0; j < times; j++){
                nums[index] = i;
                index++;
            }
        }
    }
	
	public void sortColors2(int[] nums) {
        int second = nums.length -1, zero = 0;
        for( int i = 0; i <= second; i++ ) {
            while( nums[i] == 2 && i < second ) {
                swap( nums, i, second ) ;
                second--;
            }
            while( nums[i] == 0 && i > zero ) {
                swap( nums, i, zero );
                zero++;
            }
        }
    }
    
    private void swap( int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
