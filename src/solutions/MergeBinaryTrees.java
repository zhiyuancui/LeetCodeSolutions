package solutions;

import util.TreeNode;

public class MergeBinaryTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if( t1 == null && t2 == null ){
			return null;
		}

		int val1 = 0;
		int val2 = 0;

		if( t1 != null ) {
			val1 = t1.val;
		} 
		if( t2 != null ) {
			val2 = t2.val;
		}

		TreeNode newNode = new TreeNode( val1 + val2);
		TreeNode t1left = t1 == null ? null : t1.left;
		TreeNode t1right = t1 == null ? null : t1.right;
		TreeNode t2left = t2 == null ? null : t2.left;
		TreeNode t2right = t2 == null ? null : t2.right;

		newNode.left = mergeTrees(t1left, t2left);
		newNode.right = mergeTrees(t1right, t2right);

		return newNode;
	}
}
