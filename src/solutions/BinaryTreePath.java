package solutions;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if( root == null ){
            return result;
        }
        
        generate(result,"", root);
        return result;
    }
    
    private void generate(List<String> result, String path, TreeNode root ){
        if( root == null ){
            return;
        }
        
        if( root.left == null && root.right == null ){           
            path +=  root.val;
            result.add(path);
            return;
        }
        
        path +=  root.val + "->";
        generate(result, path, root.left);
        generate(result, path, root.right);
        
    }
    
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
    
    
}
