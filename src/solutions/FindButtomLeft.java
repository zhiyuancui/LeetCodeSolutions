package solutions;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class FindButtomLeft {

	public int findBottomLeftValue(TreeNode root) {
        if( root == null ){
            return 0;
        }
        
        if( root.left == null && root.right == null ){
            return root.val;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int leftMost = 0;
      
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if( i == 0 ) leftMost = cur.val;
                if( cur.left != null ) queue.offer( cur.left );
                if( cur.right != null ) queue.offer( cur.right );
            }
        }
        
        return leftMost;
    }
}
