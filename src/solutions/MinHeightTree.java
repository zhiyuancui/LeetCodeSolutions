package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int[] edge : edges){
            if( graph.containsKey( edge[0]) ){
                graph.get(edge[0]).add(edge[1]);
            }else{
                List<Integer> l = new ArrayList<Integer>();
                l.add( edge[1] );
                graph.put( edge[0], l );
            }
            
            if( graph.containsKey( edge[1]) ){
                graph.get(edge[1]).add(edge[0]);
            }else{
                List<Integer> l = new ArrayList<Integer>();
                l.add( edge[0] );
                graph.put( edge[1], l );
            }
        }
        
        List<Integer> cur = new ArrayList<Integer>();
        
        if( n == 1 ){
            cur.add(0);
            return cur;
        }
        
        for(int i = 0; i < graph.size(); i++ ){
            if( graph.get(i).size() == 1 ){
                cur.add(i);
            }
        }
        
        //BFS
        while( true ){
            List<Integer> next = new ArrayList<Integer>();
            for( int node : cur ){
                for( int neighbor : graph.get(node) ){
                    graph.get( neighbor ).remove( node );
                    if( graph.get( neighbor ).size() == 1 ){
                        next.add( neighbor );
                    }
                }
                
                if( next.size() == 0 ){
                    return cur;
                }
                cur = next;
            }
        }
    }
}
