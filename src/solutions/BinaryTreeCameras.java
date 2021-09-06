package solutions;

import util.TreeNode;

public class BinaryTreeCameras {
    int res = 0;
    //1表示无摄像头，但是有覆盖
    // 2 本节点有摄像头
    // 0 无覆盖
    public int minCameraCover(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(helper(root) == 0) {
            res++;
        }

        return res;
    }

    private int helper(TreeNode node) {
        if(node == null) {
            return 1;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        if(left == 0 || right == 0) {
            res++;
            return 2;
        } else if(left == 2 || right == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}
