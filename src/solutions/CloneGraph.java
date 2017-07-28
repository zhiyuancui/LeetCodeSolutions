package solutions;

import java.util.ArrayList;
import java.util.HashMap;

import util.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null ){
            return null;
        }
        
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        nodes.add( node );
        map.put( node, new UndirectedGraphNode( node.label) );
        
        int index = 0;
        while( index < nodes.size() ){
            UndirectedGraphNode head = nodes.get(index);
            index++;
            for(int i = 0; i < head.neighbors.size(); i++){
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }   
            }
        }
        
        //clone neighbors
        for(UndirectedGraphNode head: nodes) {
            UndirectedGraphNode clone = map.get(head);
            for(UndirectedGraphNode item : head.neighbors) {
                clone.neighbors.add( map.get(item) );
            }
        }
        
        return map.get( node );
    }
}
