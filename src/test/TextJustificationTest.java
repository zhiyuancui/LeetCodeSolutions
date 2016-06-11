package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.TextJustification;

public class TextJustificationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TextJustification t = new TextJustification();
		String[] words = {"This","is","an","example","of","text","justification"};
		t.fullJustify(words, 16);
	}

}
