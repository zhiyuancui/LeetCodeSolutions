package solutions;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
	
	/**
	 * Majority Element
	 * @param nums
	 * @return
	 */
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
	
	
	/**
	 * Majority Element II
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if( nums == null || nums.length == 0 ){
            return result;
        }
        
        int number1 = nums[0], number2 = nums[0];
        int count1 =0, count2 = 0;
        int len = nums.length;
        
        for(int i = 0; i < len; i++){
            if( nums[i] == number1 ){
                count1++;
            }else if( nums[i] == number2 ){
                count2++;
            }else if( count1 == 0 ){
                number1 = nums[i];
                count1 = 1;
            }else if( count2 == 0 ){
                number2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0; i < len; i++){
            if( nums[i] ==  number1 ){
                count1++;
            }else if( nums[i] == number2 ){
                count2++;
            }
        }
        if( count1 > len / 3 ){
            result.add( number1 );
        }
        if( count2 > len / 3 ){
            result.add( number2 );
        }
        
        return result;
    }
	
	public static void main(String[] args){
		MajorityElement m = new MajorityElement();
		int[] nums = {4,2,1,1};
		m.majorityElement2(nums);
	}
}
