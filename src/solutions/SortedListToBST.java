package solutions;

import util.ListNode;
import util.TreeNode;

/**
 * 109 Convert Sorted List to Binary Search Tree
 */
public class SortedListToBST {

    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            len++;
        }

        cur = head;
        return buildTree(len);
    }

    private TreeNode buildTree(int size) {
        if(size <= 0 ) {
            return null;
        }
        TreeNode left = buildTree(size/2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = buildTree(size - 1 - size/2);

        root.left = left;
        root.right = right;
        return root;
    }
}
