package solutions;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class RightSideView {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) {
        	return res;
        }
        List<TreeNode> candidates = new LinkedList<TreeNode>();
        candidates.add(root);
        while(!candidates.isEmpty()) {
        	List<TreeNode> temp = new LinkedList<TreeNode>();
        	res.add(candidates.get(0).val);
        	for(TreeNode curr : candidates) {
        		if(curr.right != null)
        			temp.add(curr.right);
        		if(curr.left != null)
        			temp.add(curr.left);
        	}
        	candidates = temp;
        }
        return res;
    }
}
