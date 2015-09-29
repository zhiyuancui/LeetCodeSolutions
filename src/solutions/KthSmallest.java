package solutions;

import java.util.Stack;

import util.TreeNode;

public class KthSmallest {

	public int kthSmallest(TreeNode root, int k) {
        
        if( root == null )
        {
            return 0;
        }
        
        int count = 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while( !stack.isEmpty() || root != null )
        {
            while( root != null )
            {
                stack.push( root );
                root = root.left;
            }
            
            root = stack.pop();
            count++;
            if( count == k )
            {
                return root.val;
            }
            root = root.right;
        }
        
        return 0;
    }
}
