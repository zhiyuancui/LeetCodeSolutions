package solutions;

public class WiggleSeq {

	public int wiggleMaxLength(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        
        int increase = 1;
        int decrease = 1;
        for(int i = 1; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                increase = decrease + 1;
            }else if( nums[i] < nums[i-1] ){
                decrease = increase + 1;
            }
        }
        
        return Math.min(nums.length, Math.max(increase,decrease));
    }
}
