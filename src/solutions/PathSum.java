package solutions;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class PathSum {
    /**
     * Path Sum
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ) {
            return false;
        }
        
        sum -= root.val;
        
        if( root.left == null && root.right == null ) {
            return sum == 0;
        }
        
        
        return hasPathSum( root.left, sum) || hasPathSum( root.right, sum);
        
    }
}
