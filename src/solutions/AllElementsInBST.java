package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<Integer> result = new ArrayList<>();

        while( !stack1.isEmpty() || root1 != null || root2 != null || !stack2.isEmpty()) {
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }

            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left;
            }

            int val1 = !stack1.isEmpty() ? stack1.peek().val : Integer.MAX_VALUE;
            int val2 = !stack2.isEmpty() ? stack2.peek().val : Integer.MAX_VALUE;
            //System.out.println(val1 + " " + val2);
            if(val1 < val2) {
                result.add(val1);
                if(!stack1.isEmpty()) {
                    root1 = stack1.pop();
                    root1 = root1.right;
                }
            } else {
                result.add(val2);
                if(!stack2.isEmpty()) {
                    root2 = stack2.pop();
                    root2 = root2.right;
                }
            }
        }

        return result;
    }
}
