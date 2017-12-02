package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {

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
	
	/***
	 *  Four Sum O(N^2) solution
	 * @param num
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum2(int[] num, int target) {
        Arrays.sort(num);
    
	    Map<Integer, List<int[]>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
	    Set<List<Integer>> res = new HashSet<>();  // for holding the results
	    
	    for (int i = 0; i < num.length; i++) {
	    	// get rid of repeated pair sums
	        if (i > 1 && num[i] == num[i - 2]) continue;
	    	
	        for (int j = i + 1; j < num.length; j++) {
	            // get rid of repeated pair sums
	            if (j > i + 2 && num[j] == num[j - 2]) continue;
	
	            // for each pair sum, check if the pair sum that is needed to get the target has been visited.            	
	            if (twoSumMap.containsKey(target - (num[i] + num[j]))) {   
	                // if so, get all the pairs that contribute to this visited pair sum.
		        	List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));
		        		
		        	for (int[] pair : ls) {
		        	    // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
		        	    // we first need to check if they are overlapping with each other.
		        	    int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
	                    int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
	                    int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
	                    int m4 = Math.max(pair[1], j);  // m4 will always be the largest index
	                    
	                    if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;  // two pairs are overlapping, so just ignore this case
	 		    
	                    res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));  // else record the result
		        	}
	            }
	            
	            // mark that we have visited current pair and add it to the corrsponding pair sum group.
	            // here we've encoded the pair indices i and j into an integer array of length 2.
	            twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
	        }
	    }
    
	    return new ArrayList<List<Integer>>(res);
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
