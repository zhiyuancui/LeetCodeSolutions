package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import util.TreeNode;
public class BSTSerializer {

	private static final String spliter = ",";
	
   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       serialize( root, sb);
       return sb.toString();
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
       if( data == null || data.length() == 0 ){
           return null;
       }
       TokenContainer st = new TokenContainer(data,spliter);
       return deserialize(st);
   }
   
   private void serialize(TreeNode root, StringBuilder sb){
       if( root == null ){
           sb.append("#").append(spliter);
       }else{
           sb.append( root.val +spliter);
           serialize( root.left, sb);
           serialize( root.right, sb);
       }
   }
   
   private TreeNode deserialize(TokenContainer st) {
       if (!st.hasMoreTokens())
           return null;
       String s = st.nextToken();
       if (s.equals("#"))
           return null;
       TreeNode root = new TreeNode(Integer.valueOf(s));
       root.left = deserialize(st);
       root.right = deserialize(st);
   
       return root;
   }
   
   class TokenContainer{
	   
	   private final String target;
	   private final String splitToken;
	   private List<String> tokens;
	   
	   public TokenContainer(String target, String splitToken){
		   this.target = target;
		   this.splitToken = splitToken;
		   String[] parts =  this.target.split( this.splitToken );
		   if( parts.length > 0 ){
			   tokens = new LinkedList<String>();
			   tokens.addAll( Arrays.asList(parts) );
		   }
	   }
	   
	   public boolean hasMoreTokens(){
		   return tokens != null && tokens.size() > 0;
	   }
		   
	   public String nextToken(){
		   return tokens.remove(0);
	   }
   }
}
