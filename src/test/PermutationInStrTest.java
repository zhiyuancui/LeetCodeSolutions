package test;

import static org.junit.Assert.*;

import org.junit.Test;
import solutions.PermutationInStr;

public class PermutationInStrTest {

	@Test
	public void test() {
		PermutationInStr p = new PermutationInStr();
		assertTrue( p.checkInclusion("ab", "eidbaoo"));
	}

}
