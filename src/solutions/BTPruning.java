package solutions;

import util.TreeNode;

public class BTPruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        boolean hasOne = hasOne(root);

        if(hasOne) {
            return root;
        } else {
            return root.val == 1? root : null;
        }
    }

    private boolean hasOne(TreeNode root) {
        if(root == null) {
            return false;
        }

        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);

        //System.out.println("root " + root.val + left +" " + right);

        if(!left) {
            root.left = null;
        }

        if(!right) {
            root.right = null;
        }

        if(left || right) {
            return true;
        } else {
            return root.val == 1;
        }
    }
}
