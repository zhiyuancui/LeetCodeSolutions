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
}
