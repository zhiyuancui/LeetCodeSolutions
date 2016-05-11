package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sums {

	/**
	 * Two Sum with duplicates in the input array
	 * For example
	 * [0,3,0] 0
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
	       
	        
	        boolean first = false;
	        //Find the index;
	        for(int i = 0; i < nums.length; i++)
	        {
	            if( !first && nums[i] == result[0] )
	            {
	                result[0] = i+1;
	                first = true;
	                continue;
	            }
	            
	            if( nums[i] == result[1] )
	            {
	                result[1] = i+1;
	            }
	        }
	        
	        Arrays.sort( result );
	        
	        return result;
	    }
	 
	 
	 public int[] twoSum2(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	        int[] res = new int[2];
	        
	        for(int i = 0; i < nums.length; i++){
	            if( map.get( target-nums[i]) != null ){
	                res[0] = i;
	                res[1] = map.get( target - nums[i] );
	                return res;
	            }
	            map.put( nums[i], i );
	        }
	        
	        return res;
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
	 
	 
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> rst = new ArrayList<List<Integer>>();
			Arrays.sort(nums);

			for (int i = 0; i < nums.length - 3; i++) {
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue;
				}

				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j != i + 1 && nums[j] == nums[j - 1])
						continue;

					int left = j + 1;
					int right = nums.length - 1;
					while (left < right) {
						int sum = nums[i] + nums[j] + nums[left] + nums[right];
						if (sum < target) {
							left++;
						} else if (sum > target) {
							right--;
						} else {
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.add(nums[i]);
							tmp.add(nums[j]);
							tmp.add(nums[left]);
							tmp.add(nums[right]);
							rst.add(tmp);
							left++;
							right--;
							while (left < right && nums[left] == nums[left - 1]) {
								left++;
							}
							while (left < right && nums[right] == nums[right + 1]) {
								right--;
							}
						}
					}
				}
			}

			return rst;
	    }
	 
	 
	 /**
	  * Given an array of n integers nums and a target, 
	  * find the number of index triplets i, j, k with 0 <= i < j < k < n 
	  * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
	  * 
	  * For example, given nums = [-2, 0, 1, 3], and target = 2.
	  * 
	  * Return 2. Because there are two triplets which sums are less than 2:
	  * 
	  * [-2, 0, 1]
	  * [-2, 0, 3]
	  * 
	  * Follow up:
	  * 
	  * Could you solve it in O(n2) runtime?
	  * 
	  * Reference to : https://leetcode.com/discuss/56164/simple-and-easy-understanding-o-n-2-java-solution
	  * 
	  * @param nums
	  * @param target
	  * @return
	  */
	 int count;

    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
	 
	 public static void main(String[] args)
	 {
		 Sums s = new Sums();
		 int[] nums = {217,231,523,52,547,243,648,
				 509,415,149,689,710,265,187,370,
				 56,977,182,400,329,471,805,955,989,
				 255,766,38,566,79,843,295,229,988,108,781,
				 619,704,542,335,307,359,907,727,959,161,699,
				 123,650,147,459,657,188,304,268,405,685,620,721,
				 351,570,899,60,388,771,24,659,425,440,508,373,32,
				 645,409,272,356,175,533,740,370,152,34,510,745,251,227,
				 494,258,527,817,773,178,194,860,387,627,851,449,736,15,212,
				 529,950,316,28,65,484,968,63,4,643,795,669,203,677,139,
				 636,289,555,430,849,150,493,301,377,240,873,965,441,
				 230,349,447,470};
				
		 s.twoSum(nums,718);
		 System.out.println( nums[80-1]+ "  " + nums[104-1]);
		 System.out.println( nums[28-1]+ "  " + nums[80-1]);
		 
	 }
	
}
