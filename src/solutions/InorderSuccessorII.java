package solutions;

/**
 * 510 Inorder Successor in BST II
 */
public class InorderSuccessorII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        if(node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }

        while(node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }
}
