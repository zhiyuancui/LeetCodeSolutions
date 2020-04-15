package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
	public List<List<Integer>> verticalOrder(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 0));

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int min = Integer.MAX_VALUE;

		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i <size; i++) {
				Node cur = queue.poll();
				int index = cur.pos;
				min = Math.min(min, index);
				if(!map.containsKey(index)) {
					map.put(index, new ArrayList<>());
				}
				map.get(index).add(cur.node.val);
				if(cur.node.left != null){
					queue.add(new Node(cur.node.left, index-1));
				}
				if(cur.node.right != null){
					queue.add(new Node(cur.node.right, index+1));
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		while(!map.isEmpty()){
			if(map.containsKey(min)) {
				result.add(map.get(min)); // sort the order of map
				map.remove(min);
			}
			min++;
		}

		return result;
	}

	class Node {
		TreeNode node;
		int pos;
		public Node(TreeNode node, int pos) {
			this.node = node;
			this.pos = pos;
		}
	}
}
