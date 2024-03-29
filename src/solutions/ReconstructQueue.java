package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 406 Queue Reconstruction by Height
 */
public class ReconstructQueue {

	public int[][] reconstructQueue(int[][] people) {
		if( people == null || people.length == 0 ) {
            return new int[0][0];
        }
        
        Arrays.sort( people, (a,b) -> {
            if( a[0] != b[0] ) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        List<int[]> result = new ArrayList<>();
        for(int[] p : people ) {
            result.add( p[1], p );
        }
        
        int[][] res = new int[ result.size() ][2];
        
        for(int i = 0; i < result.size(); i++ ) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        
        return res;
    }
	
	
	/******************************************************
	 * 
	 * BST Solution
	 * @author zhiyuan.cui
	 *
	 ******************************************************/
	class Node {
		public Node left, right;
		public int lessCount;
		public int tallerCount;
		public int[] person;
		public Node(int[] p, int t){
			person = p;
			tallerCount = t;
			lessCount = 1;
		}
	}
	
	private Node root = null;
	private void insert(Node node, Node candidate){
		if( node == null ){
			root =  candidate;
			return;
		}
		
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
	
	private int[][] inorder(Node root, int size){
		if( root == null ){
			return new int[0][0];
		}
		
		int pos = 0;
		int[][] res = new int[size][2];
		Stack<Node> stack = new Stack<Node>();
		
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
			insert(root, new Node(person, person[1]));
		}
		
		return inorder(root, people.length);
	}
}
