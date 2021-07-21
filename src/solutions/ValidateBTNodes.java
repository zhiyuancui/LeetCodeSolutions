package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1361 Validate Binary Tree Nodes
 */
public class ValidateBTNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if(indegree[leftChild[i]] > 1) {
                    return false;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if(indegree[rightChild[i]] > 1) {
                    return false;
                }
            }
        }

        int root = -1;
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                if(root != -1) {
                    return false;
                }
                root = i;
            }
        }

        if(root == -1) {
            return false;
        }

        return countNodes(leftChild, rightChild, root) == n;
    }

    private int countNodes(int[] leftChild, int[] rightChild, int root) {
        if(root == -1) {
            return 0;
        }

        return 1 + countNodes(leftChild, rightChild, leftChild[root]) + countNodes(leftChild, rightChild, rightChild[root]);
    }
}
