package solutions;

import util.TreeNode;

public class StrToTree {
	public TreeNode str2tree(String s) {
		if( s == null || s.length() == 0 ) {
            return null;
        }
        
        int first = s.indexOf("(");
        if( first == -1 ) {
            return new TreeNode( Integer.parseInt(s) );
        }
        
        int cur = Integer.parseInt( s.substring(0,first) );
        TreeNode root = new TreeNode( cur );
        
        int start = first, left = 0;
        for( int i = start; i < s.length(); i++ ) {
            if( s.charAt(i) == '(' ){
                left++;
            } else if( s.charAt(i) == ')' ){
                left--;
            }
            if( start == first && left == 0 ) {
                root.left = str2tree( s.substring(start+1, i ) );
                start = i + 1;
            } else if( left == 0 ) {
                root.right = str2tree( s.substring(start+1,i) );
            }
        }
        return root;
    }
}
