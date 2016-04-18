package solutions;

import util.ListNode;
import util.TreeNode;

public class ListToBST {
	private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = 0;
        
        while( cur != null ){
            len++;
            cur = cur.next;
        }
        
        cur = head;
        
        return buildTree( len );
    }
    
    private TreeNode buildTree(int size){
        if( size <= 0 ){
            return null;
        }
        
        TreeNode left = buildTree( size / 2 );
        TreeNode root = new TreeNode( cur.val );
        cur = cur.next;
        TreeNode right = buildTree( size - 1 - size / 2 );
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
