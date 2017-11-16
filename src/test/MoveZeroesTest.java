package test;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.MoveZeroes;

public class MoveZeroesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLargeData() {
		MoveZeroes m = new MoveZeroes();
		int[] nums = new int[5000];
		Random r = new Random();
		for(int i = 0; i < 5000; i++ ) {
			nums[i] = r.nextInt(10);
			if( r.nextBoolean() ) {
				nums[i] = 0;
			}
		}
		
		m.moveZeroes(nums);
		m.moveZeroes2(nums);
	}

}
