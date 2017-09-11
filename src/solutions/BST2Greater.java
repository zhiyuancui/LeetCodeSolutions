package solutions;

import java.util.Stack;

import util.TreeNode;

public class BST2Greater {
	int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        
        reverseInorder(root);
        return root;
    }
    
    private void reverseInorder(TreeNode node){
        
        if( node == null ) {
            return;
        }
        
        reverseInorder( node.right );
        node.val += sum;
        sum = node.val;
        reverseInorder( node.left );
    }
    
    private void reverseInorderIterative(TreeNode node ){

        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while( !stack.isEmpty() || node != null ) {
            while( node != null ) {
                stack.push( node );
                node = node.right;
            }
            
            node = stack.pop();
            node.val += sum;
            sum = node.val;
            node = node.left;
        }
    }
    
}
