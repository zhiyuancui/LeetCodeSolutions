package solutions;

import util.TreeNode;

/**
 * 606 Construct String from Binary Tree
 */
public class ConstructStrFromBT {
        public String tree2str(TreeNode root) {
                if(root == null) {
                        return  "";
                }
                StringBuilder sb = new StringBuilder();
                build(root, sb);
                return sb.toString();
        }

        public void build(TreeNode node, StringBuilder sb) {
                sb.append(node.val);
                if(node.left != null) {
                        sb.append("(");
                        build(node.left, sb);
                        sb.append(")");
                } else if(node.right != null) {
                        sb.append("()");
                }


                if(node.right != null){
                        sb.append("(");
                        build(node.right, sb);
                        sb.append(")");
                }

        }
}
