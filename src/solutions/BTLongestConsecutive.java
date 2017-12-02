package solutions;

import util.TreeNode;

public class BTLongestConsecutive {
	   private int max = 0;
	    public int longestConsecutive(TreeNode root) {
	        if(root == null) return 0;
	        helper(root, 0, root.val);
	        return max;
	    }
	    
	    public void helper(TreeNode root, int cur, int target){
	        if(root == null) return;
	        if(root.val == target) cur++;
	        else cur = 1;
	        max = Math.max(cur, max);
	        helper(root.left, cur, root.val + 1);
	        helper(root.right, cur, root.val + 1);
	    }
	    
	    int maxval = 0;
	    /**
	     * Binary Tree Longest Consecutive Sequence II
	     * @param root
	     * @return
	     */
	    public int longestConsecutive2(TreeNode root) {
	        longestPath(root);
	        return maxval;
	    }
	    public int[] longestPath(TreeNode root) {
	    	//int[0] is inc, maens a path clockwise, increasing
	    	//int[1] is dcr, means a path away from the root
	        if (root == null)
	            return new int[] {0,0};
	        int inr = 1, dcr = 1;
	        if (root.left != null) {
	            int[] l = longestPath(root.left);
	            if (root.val == root.left.val + 1)
	                dcr = l[1] + 1;
	            else if (root.val == root.left.val - 1)
	                inr = l[0] + 1;
	        }
	        if (root.right != null) {
	            int[] r = longestPath(root.right);
	            if (root.val == root.right.val + 1)
	                dcr = Math.max(dcr, r[1] + 1);
	            else if (root.val == root.right.val - 1)
	                inr = Math.max(inr, r[0] + 1);
	        }
	        maxval = Math.max(maxval, dcr + inr - 1);
	        return new int[] {inr, dcr};
	    }
}
