package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.UndirectedGraphNode;

/**
 * 133 Clone Graph
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        List<Node> nodes = new ArrayList<>();

        nodes.add(node);

        map.put(node, new Node(node.val));

        int index = 0;
        while(index < nodes.size()) {
            Node cur = nodes.get(index);
            index++;

            for(Node next: cur.neighbors) {
                if(!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                    nodes.add(next);
                }
            }
        }

        for(Node cur: nodes) {
            for(Node next: cur.neighbors) {
                map.get(cur).neighbors.add(map.get(next));
            }
        }

        return map.get(node);
    }
}
