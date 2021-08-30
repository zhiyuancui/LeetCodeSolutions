package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220 Contains Duplicate III
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>(k << 1);
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = nums[i];
            long bucket = getKey(remappedNum, t);
            // System.out.println(remappedNum + ", " + bucket);
            if (map.containsKey(bucket) // means the key in the map duplicated, it means the must be exist two numbers that the different value between them are less than t
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) // if the two different numbers are located in two adjacent bucket, the value still might be less than t
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
                // System.out.println(map);
                return true; // the same reason for -1
            }
            if (map.size() >= k) {
                long lastBucket = getKey(nums[i - k], t);  //  - Integer.MIN_VALUE
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum); //replace the duplicated key
            // System.out.println(map);
        }
        return false;
    }

    private long getKey(long num, long div) {
        long key = num / (div + 1);
        if (num < 0) return key - 1;
        return key;
    }
}
