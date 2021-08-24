package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.TreeNode;

/**
 * Find Leaves of Binary Tree
 */
public class FindLeavesOfTree {
    private List<int[]> pairs;

    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        pairs = new ArrayList<>();

        getHeight(root);

        Collections.sort(this.pairs, (a, b) -> a[0] - b[0]);

        List<List<Integer>> result = new ArrayList<>();

        int height = 0;

        for(int[] item : pairs) {
            if(item[0] == height) {
                if(result.size() <= height) {
                    result.add(new ArrayList<>());
                }
                result.get(height).add(item[1]);
            } else {
                height = item[0];
                if(result.size() <= height) {
                    result.add(new ArrayList<>());
                }
                result.get(height).add(item[1]);
            }
        }

        return result;

    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int height = Math.max(left, right) + 1;

        this.pairs.add(new int[]{height, root.val});

        return height;
    }
}
