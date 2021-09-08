package solutions;

import java.util.Stack;

/**
 * 901 Online Stock Span
 */
public class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && price >= stack.peek()[0]) {
            int[] prev = stack.pop();
            span += prev[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
