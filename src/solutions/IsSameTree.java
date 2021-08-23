package solutions;

import util.*;

/**
 * 100 Same Tree
 */
public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
	     
        if( p == null && q == null )
        {
            return true;
        }
        
        if( p == null || q == null )
        {
            return false;
        }
        
        if( p.val != q.val )
        {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
