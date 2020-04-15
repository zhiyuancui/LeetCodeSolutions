package solutions.amazon;

import util.TreeNode;

import java.util.*;

public class DistanceK {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        linkParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();

        visited.add(target);
        queue.offer(target);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(K == 0) {
                    res.add(cur.val);
                } else {
                    if(parents.get(cur) != null && visited.add(parents.get(cur))) {
                        queue.offer(parents.get(cur));
                    }
                    if(cur.left != null && visited.add(cur.left)) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null && visited.add(cur.right)) {
                        queue.offer(cur.right);
                    }
                }
            }
            K--;
        }
        return res;
    }

    private void linkParent(TreeNode root, TreeNode parent) {
        if(root == null) {
            return;
        }

        parents.put(root,parent);
        linkParent(root.left, root);
        linkParent(root.right, root);
    }
}
