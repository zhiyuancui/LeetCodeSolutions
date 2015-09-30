package solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import util.TreeNode;

public class BSTIterator {

    LinkedList<Integer> nodes = new LinkedList<Integer>();
    Iterator<Integer> it;
    
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while( !stack.isEmpty() || root != null )
        {
            while( root != null )
            {
                stack.push( root );
                root = root.left;
            }
            
            root = stack.pop();
            nodes.add( root.val );
            root = root.right;
        }
        
        it = nodes.iterator();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return it.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return it.next();
    }
}

