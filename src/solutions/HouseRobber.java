package solutions;

import util.TreeNode;

public class HouseRobber {
	public int rob3(TreeNode root) {
		int[] res = robSub3(root);
	    return Math.max(res[0], res[1]);
    }
	
	private int[] robSub3(TreeNode root) {
	    if (root == null) {
	        return new int[2];
	    }

	    int[] left = robSub3(root.left);
	    int[] right = robSub3(root.right);

	    int[] res = new int[2];
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];

	    return res;
	}
}
