package solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	PriorityQueue<Double> minHeap = new PriorityQueue<>();
	PriorityQueue<Double> maxHeap = new PriorityQueue<Double>((a,b) ->(int)(b-a));

	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length - k + 1;
		if(n <= 0) return new double[0];
		double[] result = new double[n];

		for(int i = 0; i < nums.length; i++) {
			add(nums[i]);

			if(i>= k) {
				remove(nums[i-k]);
			}

			if(i >= k - 1) {
				result[i - k + 1] = getMedian();
			}
		}

		return result;
	}

	private void add(double num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	private void remove(int num) {
		if(num <= getMedian()) {
			maxHeap.remove(num);
		} else {
			minHeap.remove(num);
		}

		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}

		if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		}
	}

	private double getMedian() {
		if(maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

		if(maxHeap.size() == minHeap.size()) {
			return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
		} else {
			return (double)maxHeap.peek();
		}
	}
}
