package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.LRUCache;

public class LRUCacheTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}

}
