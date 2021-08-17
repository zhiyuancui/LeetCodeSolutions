package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 442 Find All Duplicates in an Array
 */
public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates4(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if( nums[index] < 0 ){
                result.add(index+1);
            }
            nums[index] = -nums[index];
        }

        return result;
    }
}
