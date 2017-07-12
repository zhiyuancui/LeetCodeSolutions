package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Skyline {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b:buildings) {
	        height.add(new int[]{b[0], -b[2]}); // start point has negative height value
	        height.add(new int[]{b[1], b[2]}); // end point has normal height value
	    }
	
	    // sort $height, based on the first value, if necessary, use the second to break ties
	    Collections.sort(height, (a, b) -> {
	            if(a[0] != b[0]) 
	                return a[0] - b[0];
	            return a[1] - b[1];
	    });
	
	    // Use a maxHeap to track the heighest building
	    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
	
	    // Provide a initial value to make it more consistent
	    maxHeap.offer(0);
	
	    // Before starting, the previous max height is 0;
	    int prev = 0;
	
	    // visit all points in order
	    for(int[] h:height) {
	        if(h[1] < 0) { // a start point, add height
	            maxHeap.offer(-h[1]);
	        } else {  // a end point, remove height
	            maxHeap.remove(h[1]);
	        }
	        int cur = maxHeap.peek(); // current max height;
	
	        // compare current max height with previous max height, update result and previous max height if necessary
	        if(prev != cur) {
	            result.add(new int[]{h[0], cur});
	            prev = cur;
	        }
	    }
	    return result;
    }
}
