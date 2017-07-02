package solutions;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordLadderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WordLadder w = new WordLadder();
		List<String> dict = new ArrayList<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		w.ladderLength("hit", "cog", dict);
	}

}
