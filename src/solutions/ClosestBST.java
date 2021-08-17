package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import util.TreeNode;

/**
 * 272 Closest Binary Search Tree Value II
 */
public class ClosestBST {
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
