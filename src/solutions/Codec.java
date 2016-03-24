package solutions;

import java.util.StringTokenizer;

import util.TreeNode;
public class Codec {

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
       StringTokenizer st = new StringTokenizer(data," ");
       return deserialize(st);
   }
   
   private void serialize(TreeNode root, StringBuilder sb){
       if( root == null ){
           sb.append("# ");
       }else{
           sb.append( root.val +" ");
           serialize( root.left, sb);
           serialize( root.right, sb);
       }
   }
   
   private TreeNode deserialize(StringTokenizer st) {
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
   
   
}
