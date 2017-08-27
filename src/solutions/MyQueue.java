package solutions;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> input;
    Stack<Integer> output;
    
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( output.isEmpty() ) {
            while( !input.isEmpty() ) {
                output.push( input.pop() );
            }
        }
        
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if( output.isEmpty() ) {
            while( !input.isEmpty() ) {
                output.push( input.pop() );
            }
        }
        
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
