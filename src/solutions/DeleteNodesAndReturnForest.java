package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110 Delete Nodes And Return Forest
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return new ArrayList<>();
        }

        Set<Integer> delete = new HashSet<>();
        for(int val : to_delete) {
            delete.add(val);
        }

        helper(root, delete);

        if(!delete.contains(root.val)) {
            list.add(root);
        }

        return list;
    }

    public TreeNode helper(TreeNode root, Set<Integer> delete) {
        if(root == null) {
            return null;
        }

        root.left = helper(root.left, delete);
        root.right = helper(root.right, delete);

        if(delete.contains(root.val)) {
            if(root.left != null) {
                list.add(root.left);
            }

            if(root.right != null) {
                list.add(root.right);
            }
            return null;
        }

        return root;
    }
}
