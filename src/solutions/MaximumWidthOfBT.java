package solutions;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class MaximumWidthOfBT {
	/**
	 * Space Complexity: O(N)
	 * Time Complexity: O(N)
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {
		if( root == null ) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queuePos = new LinkedList<>();
        queue.add( root );
        queuePos.add(1);
        
        int max = 1;
        int start = 1;
        int end = 1;
        
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                end = queuePos.poll();

                if( cur.left != null ) {
                    queue.add( cur.left );
                    queuePos.add( 2*end );
                }

                if( cur.right != null ) {
                    queue.add( cur.right );          
                    queuePos.add( 2*end + 1);
                }
            }
            
            if( max < end - start + 1 ) {
                max = end - start + 1;
            }

            start = queuePos.isEmpty() ? 1 : queuePos.peek();
        }
        
        return max;
    }
   
}
