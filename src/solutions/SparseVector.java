package solutions;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int key : vec.map.keySet()) {
            if(map.containsKey(key)) {
                sum += vec.map.get(key) * map.get(key);
            }
        }

        return sum;
    }
}
