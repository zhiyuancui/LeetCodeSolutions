package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	// Push element x onto stack.
    Queue<Integer> q = new LinkedList<Integer>();
    
    public void push(int x) {
        q.add(x);
        for(int i = 1;i < q.size(); i++){
            q.add( q.poll() );
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
        return q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
