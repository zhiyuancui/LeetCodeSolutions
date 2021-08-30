package solutions;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/**
 * 404 Sum of Left Leaves
 */
public class SumLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
        if( root == null ){
            return 0;
        } 
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer( root );
        int sum=0;
        while( !queue.isEmpty() ) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if( node.left != null ) {
                    if( node.left.left == null && node.left.right == null ){
                        sum += node.left.val;
                    }
                    queue.offer( node.left);
                }
                if( node.right != null ) {
                    queue.offer( node.right );
                }
            }
        }
        
        return sum;
    }
}
