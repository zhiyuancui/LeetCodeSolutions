package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872 Leaf-Similar Trees
 */
public class LeafSimiliarBT {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        getLeaf(root1, s1);
        List<Integer> s2 = new ArrayList<>();
        getLeaf(root2, s2);

        if(s1.size() != s2.size()) {
            return false;
        }

        for(int i = 0; i < s1.size(); i++) {
            if(s1.get(i) != s2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void getLeaf(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        getLeaf(root.left, result);
        getLeaf(root.right, result);
    }
}
