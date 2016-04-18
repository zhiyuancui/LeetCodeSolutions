package test;

import org.junit.Test;

import solutions.MinHeightTree;

public class MinHeightTreeTest {
	
	
	@Test
	public void test() {
		MinHeightTree t = new MinHeightTree();
		int[][] edges = new int[5][2];
		edges[0][0] = 0;
		edges[0][1] = 3;
		edges[1][0] = 1;
		edges[1][1] = 3;
		edges[2][0] = 2;
		edges[2][1] = 3;
		edges[3][0] = 4;
		edges[3][1] = 3;
		edges[4][0] = 5;
		edges[4][1] = 4;
		t.findMinHeightTrees(6, edges);
	}

}
