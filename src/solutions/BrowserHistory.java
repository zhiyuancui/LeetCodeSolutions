package solutions;

import java.util.Stack;

/**
 * 1472 Design Browser History
 */
public class BrowserHistory {
    Stack<String> history;
    Stack<String> future;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        future = new Stack<>();

        history.push(homepage);
    }

    public void visit(String url) {
        history.push(url);
        future = new Stack<>();
    }

    public String back(int steps) {
        while(steps > 0 && history.size() > 1) {
            future.push(history.peek());
            history.pop();
            steps--;
        }

        return history.peek();
    }

    public String forward(int steps) {
        while(steps > 0 && future.size() > 0) {
            history.push(future.peek());
            future.pop();
            steps--;
        }

        return history.peek();
    }
}
