package solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 480 Sliding Window Median
 */
public class SlidingWindowMedian {
	PriorityQueue<Double> minHeap = new PriorityQueue<>();
	PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public double[] medianSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < k) {
			return new double[0];
		}

		double[] result = new double[nums.length -k + 1];

		for(int i = 0; i < nums.length; i++) {
			addNum(nums[i]);

			if(i- k >= 0) {
				removeNum(nums[i-k]);
			}

			if(i-k+1 >= 0) {
				result[i-k+1] = getMedian();
			}
		}

		return result;
	}

	private void removeNum(double num) {
		if(minHeap.contains(num)) {
			minHeap.remove(num);
		} else maxHeap.remove(num);

		if(minHeap.size() > maxHeap.size() ) {
			maxHeap.add(minHeap.poll());
		} else if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		}
	}

	private void addNum(double num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());

		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	private double getMedian() {
		if(minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
}
