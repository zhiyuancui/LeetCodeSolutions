package solutions;

import java.util.*;

/**
 * 879 Advantange Shuffle
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return new int[0];
        }

        Map<Integer, Stack<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++) {
            Stack<Integer> stack = map.getOrDefault(nums2[i], new Stack<>());
            stack.push(i);
            map.put(nums2[i], stack);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[nums2.length];

        int i = 0;
        int j = 0, last = nums2.length - 1;

        while(j <= last && i < nums1.length) {
            Stack<Integer> indexes;
            if(nums1[i] <= nums2[j]) {
                indexes = map.get(nums2[last]);
                last--;
            } else {
                indexes = map.get(nums2[j]);
                j++;
            }

            result[indexes.pop()] = nums1[i];
            i++;

        }

        return result;
    }
}
