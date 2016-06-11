package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.KthSmallest;
import util.TreeNode;

public class KthSmallestTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		KthSmallest k = new KthSmallest();
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(13);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(11);
    	root.right.right = new TreeNode(17);
    	assertEquals(k.kthSmallest2(root, 2),4);
	}

}
