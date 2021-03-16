package solutions;

import java.util.*;

public class SerializeNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        //System.out.println("code: " + sb.toString());
        return sb.toString();
    }

    private void serialize(Node root, StringBuilder sb) {
        if(root == null) {
            sb.append('#').append(",");
            return;
        }

        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for(Node child: root.children) {
            serialize(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private Node deserialize(Queue<String> queue) {
        String node = queue.poll();
        if(node.equals("#")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(node));
        int size = Integer.parseInt(queue.poll());

        root.children = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            root.children.add(deserialize(queue));
        }

        return root;
    }
}
