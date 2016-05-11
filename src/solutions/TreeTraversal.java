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
	
	
	/**
	 * Binary Tree Vertical Order Traversal
	 * Given a binary tree, return the vertical order traversal of its nodes' values. 
	 * (ie, from top to bottom, column by column).
	 * 
	 * If two nodes are in the same row and column, the order should be from left to right.
	 * 
	 * Examples:
	 * 
	 * Given binary tree [3,9,20,null,null,15,7],
	 * 3
	 * /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
	 * Reference to : https://leetcode.com/discuss/75054/5ms-java-clean-solution
	 * 
	 */
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
	    if(root == null){
	    	return res;
	    }

	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();

	    q.add(root); 
	    cols.add(0);

	    int min = 0, max = 0;
	    while(!q.isEmpty()) {
	        TreeNode node = q.poll();
	        int col = cols.poll();
	        if(!map.containsKey(col)) {
	        	map.put(col, new ArrayList<Integer>());
	        }
	        map.get(col).add(node.val);

	        if(node.left != null) {
	            q.add(node.left); 
	            cols.add(col - 1);
	            if(col <= min) min = col - 1;
	        }
	        if(node.right != null) {
	            q.add(node.right);
	            cols.add(col + 1);
	            if(col >= max) max = col + 1;
	        }
	    }

	    for(int i = min; i <= max; i++) {
	        res.add(map.get(i));
	    }

	    return res;
    }
	
	
}
