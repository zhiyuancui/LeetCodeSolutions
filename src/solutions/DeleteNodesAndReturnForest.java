package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    Set<Integer> delete = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return new ArrayList<>();
        }

        for(int i : to_delete) {
            delete.add(i);
        }

        helper(root);

        if(!delete.contains(root.val)) {
            list.add(root);
        }
        return list;
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        root.left = helper(root.left);
        root.right = helper(root.right);

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
