package solutions;

import java.util.ArrayList;
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
}
