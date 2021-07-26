package solutions;

import util.TreeNode;

import java.util.*;

/**
 * 987 Vertical Order Traversal of a Binary Tree
 */
public class VerticalTraversal {
    class Node {
        int x;
        int y;
        TreeNode node;

        public Node(int x, int y, TreeNode cur) {
            this.x = x;
            this.y = y;
            this.node = cur;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0, root));

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i <size; i++) {
                Node cur = queue.poll();

                Map<Integer, List<Integer>> cache = map.getOrDefault(cur.x, new HashMap<>());
                List<Integer> list = cache.getOrDefault(cur.y, new ArrayList<>());

                list.add(cur.node.val);
                cache.put(cur.y, list);
                map.put(cur.x, cache);

                if(cur.node.left != null) {
                    queue.add(new Node(cur.x-1, cur.y+1, cur.node.left));
                }

                if(cur.node.right != null) {
                    queue.add(new Node(cur.x+1, cur.y+1, cur.node.right));
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        List<Integer> xSet = new ArrayList<>(map.keySet());
        Collections.sort(xSet);

        for(int x : xSet) {
            temp = new ArrayList<>();
            Map<Integer, List<Integer>> cache = map.get(x);

            List<Integer> ySet = new ArrayList<>(cache.keySet());
            Collections.sort(ySet);

            for(int y : ySet) {
                List<Integer> values = cache.get(y);
                Collections.sort(values);
                temp.addAll(values);
            }
            result.add(temp);
        }

        return result;
    }
}
