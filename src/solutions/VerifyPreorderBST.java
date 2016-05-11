package solutions;

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
        int low = Integer.MIN_VALUE, i = -1;
        
        for(int p : preorder){
        	if( p < low ){
        		return false;
        	}
        	
        	while( i >= 0 && p > preorder[i] ){
        		low = preorder[i];
        		i--;
        	}
        	i++;
        	preorder[i] = p;
        }
        
        return true;
    }
}
