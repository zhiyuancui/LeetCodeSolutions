package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator2 {
    int index = 0;
    List<Integer> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public int next() {
        int val =  index < list.size() ? list.get(index) : -1;
        index++;
        return val;
    }

    public boolean hasPrev() {
        return index-2 >= 0 && index <= list.size();
    }

    public int prev() {
        int val = index-2 >= 0 && index <= list.size() ? list.get(index-2) : -1;
        index--;
        return val;
    }
}
