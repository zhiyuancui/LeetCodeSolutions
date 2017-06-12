package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReconstructQueue {

	/**
	 * Reference to : https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
           }
        });
        //After Sort[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
        List<int[]> result = new LinkedList<>();
        for(int[] cur : people){
            result.add(cur[1],cur);
        }
        
        return result.toArray(new int[people.length][]);
    }
	
	
	/******************************************************
	 * 
	 * BST Solution
	 * @author zhiyuan.cui
	 *
	 ******************************************************/
	class TreeNode {
		public TreeNode left, right;
		public int lessCount;
		public int tallerCount;
		public int[] person;
		public TreeNode(int[] p, int t){
			person = p;
			tallerCount = t;
			lessCount = 1;
		}
	}
	
	private TreeNode root = null;
	private void insert(TreeNode node, TreeNode candidate){
		if( node == null ){
			root =  candidate;
			return;
		}
		//二叉树一个节点的左子树表示排在这个节点前面的人，右子数表示排在这个节点后面的人。
		//因为数组以递减序列排序。所以我可以确定candidate一定比node矮或者和node一样高。
		//所以如果candidate的tallercount如果大于当前节点的lesscount，即便当前节点所有的人都比candidate高，但candidate的位置实际还要更靠后。
		//所以candidate要去当前节点的右子树。当candidate去到右子树时，我们也就可以确定所有当前节点的左子树都要比candidate要高，所以tallercount要减去lesscount
		//
		if( candidate.tallerCount - node.lessCount >= 0 ){
			candidate.tallerCount -= node.lessCount;
			if( node.right == null ){
				node.right = candidate;
			} else {
				insert( node.right, candidate);
			}
			
		} else {
			node.lessCount++;
			if( node.left == null ){
				node.left = candidate;
			} else {
				insert( node.left, candidate);
			}
		}
	}
	
	private int[][] inorder(TreeNode root, int size){
		if( root == null ){
			return new int[0][0];
		}
		
		int pos = 0;
		int[][] res = new int[size][2];
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while( !stack.isEmpty() || root != null ){
			while( root != null ){
				stack.push( root );
				root = root.left;
			}
			
			root = stack.pop();
			res[pos][0] = root.person[0];
			res[pos][1] = root.person[1];
			root = root.right;
			pos++;
		}
		
		return res;
	}
	
	public int[][] reconstructQueue2(int[][] people) {
		if( people.length < 2 ) {
			return people;
		}
		
		Arrays.sort(people, (a,b) -> {
			if(a[0] == b[0] ){
				return a[1] - b[1];
			} else {
				return b[0] - a[0];
			}
		});
		
		for(int[] person: people){
			insert(root, new TreeNode(person, person[1]));
		}
		
		return inorder(root, people.length);
	}
}
