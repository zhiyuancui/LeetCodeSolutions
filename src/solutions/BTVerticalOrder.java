package solutions;

import java.util.*;

import util.TreeNode;

/**
 * 314 Binary Tree Vertical Order Traversal
 */
public class BTVerticalOrder {

	class Node {
		TreeNode node;
		int col;

		public Node(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}

		Map<Integer, List<Integer>> group = new HashMap<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 0));

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Node cur = queue.poll();
				int col = cur.col;
				min = Math.min(min, col);
				max = Math.max(max, col);
				List<Integer> level = group.getOrDefault(col, new ArrayList<>());
				level.add(cur.node.val);
				group.put(col, level);

				if(cur.node.left != null) {
					Node next = new Node(cur.node.left, col-1);
					queue.add(next);
				}

				if(cur.node.right != null) {
					Node next = new Node(cur.node.right, col+1);
					queue.add(next);
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for(int i = min; i <= max; i++) {
			if(group.containsKey(i)) {
				result.add(group.get(i));
			}
		}

		return result;
	}
}
