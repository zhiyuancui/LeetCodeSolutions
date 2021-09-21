package solutions;

import java.util.*;

import util.TreeNode;

/**
 * 652 Find Duplicate Subtrees
 */
public class FindDuplicateSubtrees {
	Map<String, Integer> trees;
	Map<Integer, Integer> count;
	List<TreeNode> ans;
	int t;
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		t = 1;
		trees = new HashMap<>();
		count = new HashMap<>();
		ans = new ArrayList<>();
		lookUp(root);
		return ans;
	}

	public int lookUp(TreeNode node) {
		if(node == null) {
			return 0;
		}
		String serial = node.val + "," + lookUp(node.left) + "," + lookUp(node.right);
		int uuid = trees.computeIfAbsent(serial, x -> t++);
		count.put(uuid, count.getOrDefault(uuid, 0) +1);
		if(count.get(uuid) == 2) {
			ans.add(node);
		}
		return uuid;
	}
}
