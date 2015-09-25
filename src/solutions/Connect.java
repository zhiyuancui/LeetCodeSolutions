package solutions;

import util.TreeLinkNode;

public class Connect {
public void connect(TreeLinkNode root) {
        
        if( root == null )
        {
            return;
        }
        
        while( root != null )
        {
            TreeLinkNode prev = null;
            TreeLinkNode next = null;
            for(; root != null; root = root.next )
            {
                if( next == null )
                {
                    next = root.left == null ? root.right : root.left;
                }
                
                if( root.left != null )
                {
                    if( prev != null )
                    {
                        prev.next = root.left;
                    }
                    prev = root.left;
                }
                
                if( root.right != null )
                {
                    if( prev != null )
                    {
                        prev.next = root.right;
                    }
                    prev = root.right;
                }
            }
            
            root = next;
        }
    }
}
