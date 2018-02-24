package solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindAllAnagramsTest {

	@Test
	public void test() {
		FindAllAnagrams f = new FindAllAnagrams();
		f.findAnagrams("cbaebabacd", "abc");
	}

}
