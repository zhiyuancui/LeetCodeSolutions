package test;

import org.junit.Test;

import solutions.ShuffleArray;

public class ShuffleArrayTest {

	@Test
	public void test() {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		ShuffleArray s = new ShuffleArray( nums );
		s.shuffle();
	}

}
