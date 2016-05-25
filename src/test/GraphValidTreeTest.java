package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.GraphValidTree;

public class GraphValidTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		GraphValidTree t = new GraphValidTree();
		int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		assertEquals(t.validTree(5, edges), false);
	}

}
