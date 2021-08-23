package solutions;


import java.util.List;

public class DiameterOfNaryTre {

    class TreeNode {
        List<TreeNode> children;

    }
    int res = 0;
    public int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        helper(root);

        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Integer max1 = 0;
        Integer max2 = 0;

        for(TreeNode next : root.children) {
            int temp = helper(next);
            if(temp  > max1 ) {
                max2 = max1;
                max1 = temp;
            } else if(temp > max2) {
                max2 = temp;
            }
        }

        res = Math.max(res, max1+max2);

        return Math.max(max1, max2)+1;
    }
}
