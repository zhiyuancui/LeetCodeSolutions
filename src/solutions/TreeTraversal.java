package solutions;

import util.*;
import java.util.*;

public class TreeTraversal {

	/**
	 * PostorderTraversal using stack
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        
        if( root == null )
        {
            return result;
        }
        
        TreeNode cur = null;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        cur = root;
        
        do
        {
            while( cur != null )
            {
                s.push(cur);
                cur = cur.left;
            }
            
            prev = null;
            while( !s.isEmpty() )
            {
                cur = s.pop();
                if( cur.right == prev )
                {
                    result.add( cur.val );
                    prev = cur;
                }
                else
                {
                    s.push( cur );
                    cur = cur.right;
                    break;
                }
            }
            
        }while( !s.isEmpty() );
        
        return result;
    }
	
	/**
	 * preorder
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if( root == null )
        {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        
        while( !stack.isEmpty() )
        {
            TreeNode temp = stack.pop();
            result.add( temp.val );
            if( temp.right != null )
            {
                stack.add( temp.right );
            }
            if( temp.left != null )
            {
                stack.add( temp.left );
            }
        }
        
        return result;
    }
	
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if( root == null )
        {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while( !stack.isEmpty() || root != null )
        {
            while( root != null )
            {
                stack.push( root );
                root = root.left;
            }
            
            root = stack.pop();
            result.add( root.val );
            root = root.right;
        }
        
        return result;
    }
}
