package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sums {

	/**
	 * Two Sum
	 */
	 public int[] twoSum(int[] nums, int target) {

		 if( nums == null || nums.length == 0 )
	        {
	            return new int[2];
	        }
	        
	        int[] result = new int[2];
	        
	        int[] copy = new int[ nums.length ];
	        
	        for(int i = 0; i < nums.length; i++)
	        {
	            copy[i] = nums[i];
	        }
	        Arrays.sort( copy );
	        
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while( low < high )
	        {
	            result[0] = copy[ low ];
	            result[1] = copy[ high];
	            if( copy[ low ] + copy[high] == target )
	            {
	                break;
	            }
	            else if( copy[low] + copy[high] < target )
	            {
	                low++;
	            }
	            else
	            {
	                high--;
	            }
	        }
	        
	        Arrays.sort( result);
	        
	        //Find the index;
	        for(int i = 0; i < nums.length; i++)
	        {
	            if( result[0] == 0 && nums[i] == result[0] )
	            {
	                result[0] = i+1;
	                continue;
	            }
	            
	            if( nums[i] == result[1] )
	            {
	                result[1] = i+1;
	            }
	        }
	        
	        return result;
	    }
	 
	 
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> rst = new ArrayList<List<Integer>>();
			if(nums == null || nums.length < 3) {
				return rst;
			}
			
			Arrays.sort(nums);
			
			for (int i = 0; i < nums.length - 2; i++) {
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue; // to skip duplicate numbers; e.g [0,0,0,0]
				}

				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[left] + nums[right] + nums[i];
					if (sum == 0) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
							left++;
						}
						while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
							right--;
						}
					} else if (sum < 0) {
						left++;
					} else {
						right--;
					}
				}
			}
			return rst;
	    }
	 
	 
	 public static void main(String[] args)
	 {
		 Sums s = new Sums();
		 int[] nums = {-1,-2,-3,-4,-5};
		 s.twoSum(nums, -8);
	 }
	
}
