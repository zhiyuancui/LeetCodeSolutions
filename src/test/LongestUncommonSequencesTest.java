package test;

import org.junit.Test;

import solutions.LongestUncommonSequences;

public class LongestUncommonSequencesTest {

	@Test
	public void test() {
		LongestUncommonSequences l = new LongestUncommonSequences();
		String[] strs = {"aba","cdc","eae"};
		l.findLUSlength2(strs);
	}

}
