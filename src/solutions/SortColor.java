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
}
