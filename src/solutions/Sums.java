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
	 
    /**
     * 4 Sum II
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int count = map.getOrDefault(C[i]+ D[j],0) + 1;
                map.put(C[i]+D[j], count);
            }
        }
        
        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                res += map.getOrDefault(-1*(A[i]+B[j]),0);
            }
        }
        
        return res;
    }

}
