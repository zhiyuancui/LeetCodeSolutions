package solutions;

import util.TreeNode;

import java.util.*;

public class LcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<TreeNode> leaves = getDeepestLeaves(root);

        return lowestCommonAncestor(root, leaves);
    }


    private List<TreeNode> getDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            result = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                result.add(cur);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return result;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        parent.put(root, null);

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if( cur.left != null ){
                parent.put(cur.left, cur);
                stack.push( cur.left );
            }

            if( cur.right != null ){
                parent.put(cur.right, cur);
                stack.push( cur.right );
            }
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        TreeNode node = nodes.get(0);
        while( node != null ){
            ancestors.add(node);
            node = parent.get(node);
        }

        TreeNode common = null;
        for(int i = 0; i < nodes.size(); i++) {
            common = nodes.get(i);
            while( !ancestors.contains(common) ){
                common = parent.get(common);
            }
        }
        return common;
    }
}
