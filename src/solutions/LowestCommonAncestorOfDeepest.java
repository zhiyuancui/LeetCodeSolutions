package solutions;

import java.util.*;

import util.TreeNode;

public class LowestCommonAncestorOfDeepest {
	TreeNode res = null;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    public int dfs(TreeNode root, int depth){
        if(root == null) return depth;
        int leftDepth = dfs(root.left, depth+1);
        int rightDepth = dfs(root.right, depth+1);
        if(leftDepth == rightDepth){
           if(maxDepth <= leftDepth){
               maxDepth = leftDepth;
               res = root;
           }
        }
        return Math.max(leftDepth, rightDepth);
    }	
}