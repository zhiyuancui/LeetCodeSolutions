package solutions;

import util.TreeNode;

import java.util.*;

public class SmallestSubtree {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> deepest = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            deepest = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                deepest.add(cur);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        return getCommonAncestor(root, deepest);
    }

    private TreeNode getCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        if( root == null || nodes == null) {
            return null;
        }

        if(nodes.size() == 1) {
            return nodes.get(0);
        }

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
        TreeNode first = nodes.get(0);
        while( first != null ){
            ancestors.add(first);
            first = parent.get(first);
        }

        TreeNode cur = null;
        for(int i = 1; i < nodes.size(); i++) {
            cur = nodes.get(i);
            while( !ancestors.contains(cur) ){
                cur = parent.get(cur);
            }
        }

        return cur;
    }
}
