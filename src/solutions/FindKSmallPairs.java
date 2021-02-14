package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class FindKSmallPairs {
	
	/**
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);

        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new ArrayList<>();
        }

        for(int i = 0; i < nums1.length && i < k; i++) {
            queue.add(new int[]{i,0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while(result.size() < k && !queue.isEmpty()) {
            int[] cur = queue.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[cur[0]]);
            pair.add(nums2[cur[1]]);

            result.add(pair);

            if(cur[1] + 1 < nums2.length) {
                queue.add(new int[]{cur[0], cur[1]+1});
            }
        }

        return result;

    }
}
