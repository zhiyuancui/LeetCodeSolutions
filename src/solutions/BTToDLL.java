package solutions;

import util.TreeNode;

public class BTToDLL {

	/**
	 * Do it in place
	 * Reference to: http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
	 * @param root
	 * @return
	 */
	public TreeNode convertBTToDLL( TreeNode root ) {
		if( root == null ) {
			return null;
		}
		TreeNode head = convert( root );
		while( head.left != null ) {
			head = head.left;
		}
		
		return head;
	}
	
	private TreeNode convert( TreeNode root ) {
		if( root == null ) {
			return null;
		}
		
		if( root.left != null ) {
			TreeNode left = convert( root.left );
			while( left.right != null ) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		
		if( root.right != null ) {
			TreeNode right = convert( root.right );
			while( right.left != null ) {
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}
		return root;
	}
}
