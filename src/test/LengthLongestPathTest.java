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
	/*
	@Test
	public void testMoreCompliate() {
		LengthLongestPath l = new LengthLongestPath();
		assertEquals(32,l.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
	}*/ 

}
