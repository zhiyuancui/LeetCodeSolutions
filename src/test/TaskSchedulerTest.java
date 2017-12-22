package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.TaskScheduler;

public class TaskSchedulerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TaskScheduler t = new TaskScheduler();
		int[] nums = {1,1,2,1};
		System.out.println( t.schedule(nums, 2) );
	}

}
