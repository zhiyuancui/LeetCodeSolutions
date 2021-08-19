package solutions;

import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        return result;
    }
}
