package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class FindLargestValue {
	
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max( node.val,max );
                if( node.left != null ) {
                    queue.offer( node.left );
                }
                if( node.right != null ) {
                    queue.offer( node.right );
                }
            }
            
            result.add(max);
        }
        
        return result;
    }
	
}
