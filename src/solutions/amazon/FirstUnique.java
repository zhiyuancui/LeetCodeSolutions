package solutions.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUnique {
    private Queue<Integer> queue = new LinkedList<>();
    private Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUnique(int[] nums) {
        for(int num: nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while(!queue.isEmpty() && !isUnique.get(queue.peek())) {
            queue.remove();
        }

        return queue.isEmpty() ? -1 :queue.peek();
    }

    public void add(int value) {
        if(!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            queue.add(value);
        } else {
            isUnique.put(value, false);
        }
    }
}
