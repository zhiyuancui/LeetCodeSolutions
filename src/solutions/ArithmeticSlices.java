package solutions;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices {

	/**
	 * Reference to : https://discuss.leetcode.com/topic/63302/simple-java-solution-9-lines-2ms
	 * @param nums
	 * @return
	 */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) {
            return 0;
        }

        int cur = 0;
        int sum = 0;

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                cur++; // 在你之前所有的序列上都可以加上这个数字，然后组成新序列，外加由这个数字组成一个起始的3个数字序列
                sum += cur;
            } else {
                cur =0;
            }
        }

        return sum;
    }
	
	
	/**
	 * Arithmetic Slices II
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices2(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];
    		
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);
            	
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
            		
                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
    		
        return res;
    }
}
