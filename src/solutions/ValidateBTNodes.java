package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ValidateBTNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if( n <= 0 || leftChild.length == 0 || rightChild.length == 0) {
            return false;
        }

        int[] degree = new int[n];

        for(int i=0; i < leftChild.length; i++) {
            if(leftChild[i] != -1) {
                degree[leftChild[i]]++;
            }
            if(rightChild[i] != -1) {
                degree[rightChild[i]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i < degree.length; i++) {
            System.out.println(degree[i]);
            if(degree[i] == 0) {
                queue.add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();

        if(queue.size() != 1) {
            return false;
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println("cur: " +cur);
            if(visited.contains(cur)) {
                return false;
            } else {
                visited.add(cur);
            }
            if(leftChild[cur] != -1) {
                degree[leftChild[cur]]--;
                queue.add(leftChild[cur]);
            }
            if(rightChild[cur] != -1) {
                degree[rightChild[cur]]--;
                queue.add(rightChild[cur]);
            }
        }

        for(int i = 0; i < degree.length; i++) {
            System.out.print(degree[i]+", ");
            if(degree[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
