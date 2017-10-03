package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if( node == null ) {
            return null;
        }
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        
        nodes.add( node );
        map.put(node, new UndirectedGraphNode(node.label) );
        int index = 0;
        while( index < nodes.size() ) {
            UndirectedGraphNode cur = nodes.get(index);
            index++;

            for( UndirectedGraphNode next : cur.neighbors ) {
                if( !map.containsKey(next) ) {
                    UndirectedGraphNode clone = new UndirectedGraphNode( next.label );
                    map.put( next, clone );
                    nodes.add(next);
                }
            }
        }
        
        for(UndirectedGraphNode cur : nodes) {
            for(UndirectedGraphNode next : cur.neighbors ) {
                map.get(cur).neighbors.add( map.get(next) );
            }
        }
        
        return map.get( node );
    }
}
