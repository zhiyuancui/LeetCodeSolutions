package solutions;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class AddOneRowToTree {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if( root == null ) {
            return root;
        }
        
        if( d ==  1 ) {
            TreeNode newHead = new TreeNode(v);
            newHead.left = root;
            return newHead;
        }
        
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer( root );

        while( level < d - 1) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if( node.left != null ) {
                    queue.offer( node.left );
                }
                if( node.right != null ) {
                    queue.offer( node.right );
                }
            }
            level++;
        }
        
        while( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            if( node.left != null ) {
                TreeNode add = new TreeNode(v);
                add.left = node.left;
                node.left = add;
            } else {
                TreeNode add = new TreeNode(v);
                node.left = add;
            }
            if( node.right != null ) {
                TreeNode add = new TreeNode(v);
                add.right = node.right;
                node.right = add;
            } else {
                TreeNode add = new TreeNode(v);
                node.right = add;
            }
        }
        
        return  root;
    }
}
