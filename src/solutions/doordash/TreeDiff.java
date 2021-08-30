package solutions.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDiff {

    class TreeNode{
        String key;
        int value;
        boolean isActive;
        List<TreeNode> children;

        public TreeNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public int countDiff(TreeNode node1, TreeNode node2) {
        if(node1 ==null && node2 == null) {
            return 0;
        }

        if(node1 == null || node2 == null || !node1.key.equals(node2.key)) {
            return countNodes(node1) + countNodes(node2);
        }

        int diff = 0;
        if(node1.value != node2.value) {
            diff++;
        }

        HashMap<String, TreeNode> childrenMap1 = new HashMap<>();
        for(TreeNode node : node1.children) {
            childrenMap1.put(node.key, node);
        }

        HashMap<String, TreeNode> childrenMap2 = new HashMap<>();
        for(TreeNode node : node2.children) {
            childrenMap1.put(node.key, node);
        }

        for(String key : childrenMap1.keySet()) {
            TreeNode child1 = childrenMap1.get(key);
            TreeNode child2 = childrenMap2.get(key);

            if(child2 == null) {
                diff += countNodes(child1);
                continue;
            }

            childrenMap2.remove(key);
            diff += countDiff(child1, child2);
        }

        for(String key: childrenMap2.keySet()) {
            diff += countNodes(childrenMap2.get(key));
        }

        return diff;
    }

    private int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int count = 1;

        for(TreeNode child : node.children) {
            count += countNodes(child);
        }

        return count;
    }
}
