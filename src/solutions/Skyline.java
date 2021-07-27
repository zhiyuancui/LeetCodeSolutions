package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 218 The Skyline Problem
 */
public class Skyline {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		if(buildings == null || buildings.length == 0) {
			return new ArrayList<>();
		}

		List<int[]> heights = new ArrayList<>();

		for(int[] b : buildings) {
			heights.add(new int[]{b[0], -b[2]});
			heights.add(new int[]{b[1], b[2]});
		}

		Collections.sort(heights, (a,b)->{
			if(a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
		queue.offer(0);


		int prev = 0;

		List<List<Integer>> result = new ArrayList<>();

		for(int[] h : heights) {
			if(h[1] < 0) {
				queue.add(-h[1]);
			} else {
				queue.remove(h[1]);
			}

			int cur  = queue.peek();
			if(cur != prev) {
				prev = cur;
				List<Integer> item = new ArrayList<>();
				item.add(h[0]);
				item.add(cur);
				result.add(item);
			}
		}

		return result;
	}
}
