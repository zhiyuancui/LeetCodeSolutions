package solutions;

import java.util.Stack;

public class VerifyPreorderBST {

	/**
	 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
	 * You may assume each number in the sequence is unique.
	 * 
	 * Follow up:
	 * 
	 * Could you do it using only constant space complexity?
	 * 
	 * Reference to : https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
	 * 
	 * @param preorder
	 * @return
	 */
	public boolean verifyPreorder(int[] preorder) {
		int min = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < min)
                return false;
            while (!path.empty() && p > path.peek())
                min = path.pop();
            path.push(p);
        }
        return true;
    }
}
