package solutions;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161 Maximum Level Sum of a Binary Tree
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();


        TreeNode currentNode = null;
        queue.offer(root);
        queue.offer(null);


        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int maxLevel = 0;
        int currentLevel = 0;

        while(!queue.isEmpty()){
            currentSum = 0;
            currentNode = queue.poll();
            if(currentNode!=null){
                while(currentNode!=null){
                    currentSum += currentNode.val;

                    if(currentNode.left!=null){
                        queue.add(currentNode.left);
                    }

                    if(currentNode.right!=null){
                        queue.add(currentNode.right);
                    }

                    currentNode = queue.poll();
                }

                currentLevel++;
                if(maxSum < currentSum){
                    maxSum = currentSum;
                    maxLevel = currentLevel;
                }

                queue.offer(null);
            }

        }

        return maxLevel;
    }
}
