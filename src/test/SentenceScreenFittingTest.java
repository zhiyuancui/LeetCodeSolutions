package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.SentenceScreenFitting;

public class SentenceScreenFittingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SentenceScreenFitting s = new SentenceScreenFitting();
		String[] sentence = {"a","bcd","e"};
		s.wordsTyping(sentence, 3, 6);
	}

}
