package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 895 Maximum Frequency Stack
 */
public class MaximumFrequencyStack {
    HashMap<Integer, Integer> count = new HashMap<>();
    Map<Integer, Stack<Integer>> group = new HashMap<>();
    int max = 0;
    public MaximumFrequencyStack() {

    }

    public void push(int val) {
        int freq = count.getOrDefault(val, 0) + 1;

        count.put(val, freq);
        max = Math.max(max, freq);

        if(!group.containsKey(freq)) {
            group.put(freq, new Stack<>());
        }
        group.get(freq).push(val);
    }

    public int pop() {
        int x = group.get(max).pop();
        count.put(x, count.get(x)-1);

        if(group.get(max).isEmpty()) {
            max--;
        }
        return x;
    }
}
