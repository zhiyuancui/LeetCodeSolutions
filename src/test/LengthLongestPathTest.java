package test;

import org.junit.Test;
import static org.junit.Assert.*;

import solutions.LengthLongestPath;

public class LengthLongestPathTest {

	@Test
	public void test() {
		LengthLongestPath l = new LengthLongestPath();
		assertEquals(0,l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}

}
