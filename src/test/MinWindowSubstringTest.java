package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import solutions.MinWindowSubstring;


public class MinWindowSubstringTest {

	@Test
	public void test() {
		MinWindowSubstring solution = new MinWindowSubstring();
		String result = solution.minWindow("cabwefgewcwaefgcf","cae");
		Assert.assertEquals("cwae", result);
	}

}
