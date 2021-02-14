package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack = new Stack<>();
    List<Integer> max = new ArrayList<>();
    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(max.size()>0) {
            int last = max.get(max.size()-1);
            if(last > x) {
                x = last;
            }
        }

        max.add(x);
    }

    public int pop() {
        max.remove(max.size()-1);
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.get(max.size()-1);
    }

    public int popMax() {
        int max = peekMax();
        List<Integer> buffer = new ArrayList<>();

        while(top() != max) {
            buffer.add(pop());
        }
        pop();

        for(int i = buffer.size()-1; i>=0; i--) {
            push(buffer.get(i));
        }

        return max;
    }
}
