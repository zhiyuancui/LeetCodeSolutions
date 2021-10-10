package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1530 Number of Good Leaf Nodes Pairs
 */
public class NumberOfGoodLeaves {
    int res = 0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);

        return res;
    }

    public List<Integer> helper(TreeNode root, int distance) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        if(root.left == null && root.right == null) {
            result.add(1);
            return result;
        }

        List<Integer> left = helper(root.left, distance);

        for(int item : left) {
            item++;
            if(item <= distance) {
                result.add(item);
            }
        }

        List<Integer> right = helper(root.right, distance);

        for(int item : right) {
            item++;
            if(item <= distance) {
                result.add(item);
            }
        }

        for(int len1 : left) {
            for(int len2 : right) {
                res += (len1 + len2) <= distance ? 1: 0;
            }
        }

        return result;
    }
}
