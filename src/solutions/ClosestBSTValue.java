package solutions;

import util.TreeNode;

/**
 * 270 Closest Binary Search Tree Value
 */
public class ClosestBSTValue {

    public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }

        int closest = root.val;

        while(root != null) {

            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;

            if(target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
}
