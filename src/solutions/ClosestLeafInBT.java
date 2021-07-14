package solutions;


import util.TreeNode;

/**
 * 742 Closest Leaf in a Binary Tree
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms
 */
public class ClosestLeafInBT {
    TreeNode ans;
    int minDist = Integer.MAX_VALUE;

    public int findClosestLeaf(TreeNode root, int k) {
        helper(root, k);
        return ans.val;
    }

    private int helper(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        if(root.val == k) {
            if(root.left == null && root.right == null) {
                minDist = 0;
                ans = root;
            } else {
                findMinDistLeaf(root.left, 1);
                findMinDistLeaf(root.right, 1);
            }

            return 0;
        }

        int left = helper(root.left, k);

        if(left >= 0) {
            findMinDistLeaf(root.right, left + 1);
            return left + 1;
        }

        int right = helper(root.right, k);
        if(right >= 0) {
            findMinDistLeaf(root.left, right + 1);
            return right + 1;
        }

        return -1;
    }

    private void findMinDistLeaf(TreeNode root, int dist) {
        if(root == null || dist > minDist) {
            return;
        }

        if(root.left == null && root.right == null) {
            if(dist < minDist) {
                minDist = dist;
                ans = root;
            }
        } else {
            findMinDistLeaf(root.left, dist + 1);
            findMinDistLeaf(root.right, dist + 1);
        }
    }
}
