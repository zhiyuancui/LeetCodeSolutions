package test;

import org.junit.Test;

import solutions.ReconstructQueue;

public class ReconstructQueueTest {

	@Test
	public void test() {
		ReconstructQueue r = new ReconstructQueue();
		int[][] people ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		r.reconstructQueue2(people);
	}

}
