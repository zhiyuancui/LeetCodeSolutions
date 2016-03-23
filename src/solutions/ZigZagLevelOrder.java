package solutions;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class ZigZagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isZigZag = false;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null ){
            return result;
        }
        
        List<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add( root );
        while( !cur.isEmpty() ){
            List<Integer> level = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for( TreeNode node : cur ){
                
                if( !isZigZag ){
                    level.add( node.val );
                }else{
                    level.add(0, node.val);
                }
                
                if( node.left != null ){
                    next.add( node.left);
                }
                if( node.right != null ){
                    next.add( node.right );
                }
            }
            isZigZag = !isZigZag;
            result.add( level );
            cur = next;
        }
        
        return result;
    }
}
