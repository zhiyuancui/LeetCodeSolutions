package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import util.TreeNode;

public class ClosestBST {

	/**
	 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
	 * Note:
	 * Given target value is a floating point.
	 * You may assume k is always valid, that is: k �� total nodes.
	 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
	 * Follow up:
	 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
	 * 
	 * Reference to :
	 * 
	 * @param root
	 * @param target
	 * @param k
	 * @return
	 */
public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        List<Integer> result = new ArrayList<Integer>();

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
        return (int)(Math.abs(b-target) - Math.abs(a-target));
    });

        Stack<Integer> successors = new Stack<Integer>();
        Stack<Integer> predecessors = new Stack<Integer>();
        
        inorder( root, target, false, successors);
        inorder( root, target, true, predecessors );
        
        while( k-- > 0 ){
            if( successors.isEmpty() ){
                result.add( predecessors.pop() );
            }else if( predecessors.isEmpty() ){
                result.add( successors.pop() );
            }else if( Math.abs(successors.peek() - target ) < Math.abs( predecessors.peek() - target ) ){
                result.add( successors.pop() );
            }else{
                result.add( predecessors.pop() );
            }
        }
     
        return result;   
    }
    
    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
        if( root == null ){
            return;
        }
        
        inorder( reverse ? root.right : root.left, target, reverse, stack);
        
        if( reverse && root.val <= target || (!reverse && root.val > target ) ){
            return;
        }
        
        stack.push( root.val );
        
        inorder( reverse ? root.left : root.right, target, reverse, stack);
    }
    
    /**
     * Closest Value in BST
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
    
    /**
     * Leetcode 270: Closest Value in BST,  Iterative way
     * @param root
     * @param target
     * @return
     */
    public int closestValue2(TreeNode root, double target) {
    		if( root == null ) {
            return 0;
        }
        int closest = root.val;
        while( root != null ) {
            if( Math.abs(closest-target) >= Math.abs(root.val-target) ) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        
        return closest;
    }
}
