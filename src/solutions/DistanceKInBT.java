package solutions;

import util.TreeNode;

import java.util.*;

public class DistanceKInBT {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) {
            return new ArrayList<>();
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        List<Integer> result = new ArrayList<>();

        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size;i++) {
                TreeNode node = queue.poll();
                if(dist == K) {
                    result.add(node.val);
                    continue;
                }

                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if(par != null && !visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }
            }
            dist++;
        }

        return result;
    }
}
}
