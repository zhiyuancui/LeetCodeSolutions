package solutions;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();

        int ans = 0;

        while(!stack.isEmpty() || root != null) {
            while(root!= null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val >= low && root.val <= high) {
                ans += root.val;
            }

            root = root.right;
        }

        return ans;
    }
}
