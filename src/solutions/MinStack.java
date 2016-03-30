package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
    List<Integer> myMins = new ArrayList<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if( myMins.size() == 0 ){
            myMins.add(x);
        }else{
            int temp = myMins.get( myMins.size() - 1 );
            if( x < temp ){
                temp = x;
            }
            myMins.add(temp);
        }
    }

    public void pop() {
        stack.pop();
        myMins.remove( myMins.size() - 1 );
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return myMins.get( myMins.size() - 1 );
    }
}
