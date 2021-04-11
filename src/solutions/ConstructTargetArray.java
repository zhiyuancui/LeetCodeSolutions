package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructTargetArray {
    public boolean isPossible(int[] target) {
        if(target == null || target.length == 0) {
            return true;
        }

        if(target.length == 1) {
            return target[0] == 1;
        }

        int totalSum = Arrays.stream(target).sum();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b-a);

        for(int num : target) {
            queue.add(num);
        }

        while(queue.peek() > 1) {
            int largest = queue.remove();

            int x = largest - (totalSum - largest);
            if(x<1) return false;

            queue.add(x);
            totalSum = totalSum - largest + x;
        }


        return true;
    }

    public boolean isPossible2(int[] target) {
        if(target == null || target.length == 0) {
            return true;
        }

        if(target.length == 1) {
            return target[0] == 1;
        }

        int totalSum = Arrays.stream(target).sum();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> b-a);

        for(int num : target) {
            queue.add(num);
        }

        while(queue.element() > 1) {
            int largest = queue.remove();

            int rest = totalSum - largest;
            if(rest == 1) {
                return true;
            }

            int x = largest % rest;

            if(x == 0 || x == largest) {
                return false;
            }
            queue.add(x);
            totalSum = totalSum - largest + x;
        }


        return true;
    }
}
