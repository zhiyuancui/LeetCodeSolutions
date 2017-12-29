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
	public List<List<Integer>> fourSum2(int[] nums, int target) {
        if( nums == null || nums.length < 4 ) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for( int i = 0; i < nums.length; i++ ) {
            if( i > 1 && nums[i-2] == nums[i] ) {
                continue;
            }
            for( int j = i+1; j < nums.length; j++ ) {
                if( j > i + 2 && nums[j-2] == nums[j] ) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if( map.containsKey( target - sum ) ) {
                    for( int[] pair : map.get(target-sum) ) {
                        int m1 = Math.min( pair[0], i );
                        int m2 = Math.min( pair[1], j);
                        int m3 = Math.max( pair[0],i);
                        int m4 = Math.max( pair[1],j);
                        if( m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4 ) {
                            continue;
                        }
                        
                        List<Integer> temp = new ArrayList<>();
                        temp.add( nums[m1] );
                        temp.add( nums[Math.min(m2,m3)]);
                        temp.add( nums[Math.max(m2,m3)]);
                        temp.add( nums[m4] );
                        result.add( temp );
                    }
                    
                } 
                if( !map.containsKey(sum) ) {
                    map.put( sum, new ArrayList<>() );
                }
                List<int[]> list = map.get(sum);
                list.add( new int[]{i,j});
            }
        }
        
        return new ArrayList<>( result );
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
