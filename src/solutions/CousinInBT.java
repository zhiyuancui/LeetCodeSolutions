package solutions;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinInBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        int level = 0;
        int firstLevel = -1;
        TreeNode parent = null;
        parents.put(root, null);
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.val == x || cur.val == y) {
                    if(parent == null) {
                        parent = parents.get(cur);
                    }
                    if(firstLevel == -1) {
                        firstLevel = level;
                    } else if(firstLevel != level) {
                        return false;
                    } else {
                        return parent.val != parents.get(cur).val;
                    }
                }
                if(cur.left != null) {
                    parents.put(cur.left, cur);
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    parents.put(cur.right, cur);
                    queue.add(cur.right);
                }

            }
            level++;
        }

        return true;
    }
}
