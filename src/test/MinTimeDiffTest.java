package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solutions.MinTimeDiff;

public class MinTimeDiffTest {

	@Test
	public void test() {
		MinTimeDiff m = new MinTimeDiff();
		List<String> timePoints = new ArrayList<String>();
		timePoints.add("23:59");
		timePoints.add("00:00");
		assertEquals(1,m.findMinDifference(timePoints));
	}

}
