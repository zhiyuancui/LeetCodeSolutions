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
            int prevlen = path.length();
            path +=  root.val;
            result.add(path);
            path = path.substring(0, prevlen);
            return;
        }
        
        int prevlen = path.length();
        path +=  root.val + "->";
        generate(result, path, root.left);
        generate(result, path, root.right);
        path = path.substring(0, prevlen);
        
    }
}
