package solutions.amazon;

import util.TreeNode;

public class BSTToGST {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        calc(root);
        return root;
    }

    private void calc(TreeNode root){
        if(root == null)
            return;

        calc(root.right);
        sum+= root.val;
        root.val = sum;
        calc(root.left);
    }
}
