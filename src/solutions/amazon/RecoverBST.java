package solutions.amazon;

import util.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 99 Recover Binary Search Tree
 */
public class RecoverBST {

	private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode last = null;
    
    public void recoverTree(TreeNode root) {
        
        if( root == null ) {
            return;
        }
        
        travel( root );
        
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void travel( TreeNode root ) {

        int[] nums = new int[3];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        if( root == null ) {
            return;
        }
        
        travel( root.left );
        if( last != null && first == null && root.val <= last.val ) {
            first = last;
        }
        if( first != null && root.val <= last.val ) {
            second = root;
        }
        
        last = root;
        travel( root.right);
    }
    
}
