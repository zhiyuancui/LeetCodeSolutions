package solutions;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if( root == null ){
            return result;
        }
        
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        
        curLevel.add( root );
        
        while( !curLevel.isEmpty() ){
            
            List<TreeNode> next = new ArrayList<TreeNode>();
            List<Integer> value = new ArrayList<Integer>();
            for(TreeNode node: curLevel){
                value.add( node.val );
                if( node.left != null ){
                    next.add( node.left );
                }
                if( node.right != null ){
                    next.add( node.right );
                }
            }
            result.add(0,value);
            curLevel = next;
        }
        
        return result;
    }
	
	public static void main(String[] args){
		LevelOrderBottom l = new LevelOrderBottom ();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		l.levelOrderBottom(root);
	}
}
