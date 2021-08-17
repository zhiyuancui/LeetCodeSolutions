package solutions;

import util.TreeNode;

import java.util.HashMap;

/**
 * 437 Path Sum III
 */
public class PathSumIII {

    public int pathSum3(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int currSum, int target, HashMap<Integer,Integer> preSum) {
        if( root == null ) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum,0) + 1 );

        res += helper(root.left, currSum, target, preSum) +  helper(root.right, currSum, target, preSum);
        preSum.put( currSum, preSum.get(currSum) - 1 );
        return res;
    }

    /**
     * Path Sum III Recursive Method
     * Space: O(n) recursion
     * Time: O(n^2) in worst case; O(nlogn) is best case
     * @param root
     * @param sum
     * @return
     */
    public int pathSum4(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom2(root, sum) + pathSum4(root.left, sum) + pathSum4(root.right, sum);
    }

    private int pathSumFrom2(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom2(node.left, sum - node.val) + pathSumFrom2(node.right, sum - node.val);
    }
}
