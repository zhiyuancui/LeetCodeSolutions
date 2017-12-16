package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.BTToDLL;
import util.TreeNode;

public class BTToDLLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BTToDLL b = new BTToDLL();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(36);
		
		TreeNode head = b.convertBTToDLL(root);
		while( head != null ) {
			System.out.println(head.val);
			head = head.right;
		}
	}

}
