package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.TreeNode;

public class PathSum {

	/**
	 * Path Sum II
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null ){
            return result;
        }
        
        List<Integer> solution = new ArrayList<Integer>();
        findSum(result, solution, root, sum);
        return result;
    }
    
    private void findSum(List<List<Integer>> result,List<Integer> solution, TreeNode root, int sum ){
        if( root == null ){
            return;
        }
        
        sum -= root.val;
        
        if( root.left == null && root.right == null ){
            if( sum == 0 ){
                solution.add( root.val );
                result.add( new ArrayList<Integer>( solution ));
                solution.remove( solution.size() - 1 );
            }
            return;
        }
        
        solution.add( root.val );
        findSum(result, solution, root.left, sum);
        findSum(result, solution, root.right, sum);
        solution.remove( solution.size() - 1 );
    }
    
    /**
     * Path Sum III
     * @param root
     * @param sum
     * @return
     */
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
     * Path Sum
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ) {
            return false;
        }
        
        sum -= root.val;
        
        if( root.left == null && root.right == null ) {
            if( sum == 0 ) {
                return true;
            } else {
                return false;
            }
        }
        
        
        return hasPathSum( root.left, sum) || hasPathSum( root.right, sum);
        
    }
}
