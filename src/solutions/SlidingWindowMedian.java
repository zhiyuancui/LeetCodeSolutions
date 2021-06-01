package solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	PriorityQueue<Double> minHeap;
	PriorityQueue<Double> maxHeap;
	public double[] medianSlidingWindow(int[] nums, int k) {
		// 最小堆
		minHeap = new PriorityQueue<>();
		// 最大堆
		maxHeap = new PriorityQueue<>(11, new Comparator<Double>()
		{
			@Override
			public int compare (Double a, Double b)
			{
				return b.compareTo(a);
			}
		});

		double[] result = new double[nums.length-k+1];

		for (int i=0; i<nums.length; i++)
		{
			addNum(nums[i]);

			if (i >= k)
			{
				removeNum(nums[i-k]);
			}

			if (i -k + 1 >= 0)
			{
				result[i-k+1] = findMedian();
			}
		}

		return result;
	}

	// 0<= minHeap.size - maxHeap.size <= 1
	// 295. Find Median from Data Stream
	private void addNum(double num) {
		minHeap.add(num);
		maxHeap.add(minHeap.poll());
		if (maxHeap.size() > minHeap.size())
		{
			minHeap.add(maxHeap.poll());
		}
	}

	private double findMedian()
	{
		if (minHeap.isEmpty() && maxHeap.isEmpty())
		{
			return 0.0;
		}
		if (minHeap.size() == maxHeap.size())
		{
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		}
		else
		{
			return minHeap.peek();
		}
	}

	private void removeNum(double num)
	{
		if (num <= findMedian())
		{
			maxHeap.remove(num);
		}
		else
		{
			minHeap.remove(num);
		}

		if (maxHeap.size() > minHeap.size()) {
			minHeap.add(maxHeap.poll());
		}

		if (minHeap.size() - maxHeap.size() > 1)
		{
			maxHeap.add(minHeap.poll());
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian s = new SlidingWindowMedian();
		int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
		s.medianSlidingWindow(nums,3);
	}
}
