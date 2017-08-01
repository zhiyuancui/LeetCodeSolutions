package solutions;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].
 * @author Zhiyuan
 *
 */
public class FindLeavesOfTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        
        height(root,result);
        return result;
    }
    
    private int height(TreeNode root, List<List<Integer>> result) {
        if( null == root ) return -1;
        int level = Math.max(height(root.left, result), height(root.right,result)) + 1;
        if( result.size() < level + 1 ) result.add(new ArrayList<>());
        result.get(level).add( root.val );
        return level;
    }
}
