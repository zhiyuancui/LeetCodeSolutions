package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>( Collections.reverseOrder() );
    
    public void addNum(int num) {
        maxHeap.offer( num );
        minHeap.offer( maxHeap.poll() );
        if( maxHeap.size() < minHeap.size() ){
            maxHeap.offer( minHeap.poll() );
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if( maxHeap.size() == minHeap.size() ){
            return ( maxHeap.peek() + minHeap.peek() ) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }
    
    public static void main(String[] args){
    	 MedianFinder m = new MedianFinder();
    	 m.addNum(1);
    	 m.addNum(2);
    	 m.addNum(3);
    	 m.findMedian();
    }
}
