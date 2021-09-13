package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 1172 Dinner Plate Stacks
 */
public class DinnerPlates {
    List<Stack> stacks;
    TreeSet<Integer> left;
    int capacity;
    public DinnerPlates(int capacity) {
        stacks = new ArrayList<>();
        this.capacity = capacity;
        left = new TreeSet<>();
    }

    public void push(int val) {
        if(left.size() == 0) {
            Stack<Integer> cur = new Stack<>();
            cur.push(val);
            stacks.add(cur);
            if(capacity > 1) {
                left.add(stacks.size() - 1);
            }
        } else {
            int index = left.first();
            Stack<Integer> cur = stacks.get(index);

            cur.push(val);
            if(cur.size() == capacity) {
                left.remove(index);
            }
        }
    }

    public int pop() {
        int ans = -1;
        int index = stacks.size() - 1;
        if(index >= 0) {
            Stack<Integer> cur = stacks.get(index);
            ans = cur.pop();
            if(cur.size() == 0) {
                while(index >= 0 && (cur = stacks.get(index)).size() == 0) {
                    stacks.remove(index);
                    left.remove(index);
                    index--;
                }
            } else {
                left.add(index);
            }
        }

        return ans;
    }

    public int popAtStack(int index) {
        int len = stacks.size();
        if(index == len-1)
            return pop();

        int ans = -1;
        Stack<Integer> curr;
        if(index < len && (curr = stacks.get(index)).size() > 0){
            ans = curr.pop();
            left.add(index);
        }
        return ans;
    }
}
