package solutions;

import java.util.*;

import util.TreeNode;

public class BTVerticalOrder {
	/**
	 * Binary Tree Vertical Order Traversal
	 * Given a binary tree, return the vertical order traversal of its nodes' values. 
	 * (ie, from top to bottom, column by column).
	 * 
	 * If two nodes are in the same row and column, the order should be from left to right.
	 * 
	 * Examples:
	 * 
	 * Given binary tree [3,9,20,null,null,15,7],
	 * 3
	 * /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
	 * Reference to : https://leetcode.com/discuss/75054/5ms-java-clean-solution
	 * 
	 */
	class Node {
		TreeNode node;
		int x;
		int y;
		public Node(TreeNode node, int x, int y) {
			this.node = node;
			this.x = x;
			this.y = y;
		}

	}
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}

		Map<Integer, List<Node>> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(root,0,0));
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int level = 0;

		while(!queue.isEmpty()) {
			int size = queue.size();
			level++;
			for(int i = 0; i < size; i++) {
				Node cur = queue.poll();
				if(!map.containsKey(cur.y)) {
					map.put(cur.y, new ArrayList<>());
				}
				List<Node> list = map.get(cur.y);
				list.add(cur);
				max = Math.max(max, cur.y);
				min = Math.min(min, cur.y);

				if(cur.node.left != null) {
					queue.offer(new Node(cur.node.left,level,cur.y-1));
				}
				if(cur.node.right != null) {
					queue.offer(new Node(cur.node.right,level,cur.y+1));
				}
			}
		}


		ArrayList<List<Integer>> result = new ArrayList<>();
		for(int i = min; i<= max; i++) {
			if(map.containsKey(i)) {
				List<Node> list = map.get(i);
				Collections.sort(list, (a, b)->{
							if(a.x == b.x && a.y == b.y) {
								return a.node.val - b.node.val;
							}
							return 0;
						}
				);
				List<Integer> solution = new ArrayList<>();
				for(Node n: list) {
					solution.add(n.node.val);
				}
				result.add(solution);
			}
		}
		return result;
	}
}
