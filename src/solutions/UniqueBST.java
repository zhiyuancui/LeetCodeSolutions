package solutions;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class UniqueBST {

	
	/**
	 * Unique Binary Search Tree II
	 * @param n
	 * @return
	 */
	public ArrayList<TreeNode> generateTrees(int n) {
		if( n <= 0 ){
            return new ArrayList<TreeNode>();
        }
        return generate(1, n);
    }
    
    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();   
    
        if(start > end){
            rst.add(null);
            return rst;
        }
     
            for(int i=start; i<=end; i++){
                ArrayList<TreeNode> left = generate(start, i-1);
                ArrayList<TreeNode> right = generate(i+1, end);
                for(TreeNode l: left){
                    for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                        TreeNode root = new TreeNode(i);  
                        root.left = l;
                        root.right = r;
                        rst.add(root);
                    }
                }
            }
        return rst;
    }
}
