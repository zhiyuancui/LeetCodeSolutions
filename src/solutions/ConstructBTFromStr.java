package solutions;

public class ConstructBTFromStr {
    Stack<TreeNode> stack = new Stack<>();

    int idx = 0;
        while(idx < s.length()){
        int i = idx;
        while(i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')'){
            i++;
        }
        if(i != idx){    //)( or )): cannot form new digit and push stack
            String sub = s.charAt(idx) == '-' ? s.substring(idx + 1, i) : s.substring(idx, i);
            int val = s.charAt(idx) == '-' ? (-1) * Integer.parseInt(sub) : Integer.parseInt(sub);
            TreeNode newNode = new TreeNode(val);
            stack.add(newNode);
        }

        if(i == s.length()) break;
        if(s.charAt(i) == '('){
            idx = i + 1;        //if s[i] == '(' no need to do sth
        }else if(s.charAt(i) == ')'){       //add left node or right node
            TreeNode temp = stack.pop();
            if(stack.isEmpty()) break;
            TreeNode root = stack.peek();
            if(root.left == null) root.left = temp;
            else root.right = temp;
            idx = i + 1;
        }
    }

        return !stack.isEmpty() ? stack.pop() : null;
}
