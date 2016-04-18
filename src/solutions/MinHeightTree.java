package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        if( n == 1 ){
            result.add(0);
            return result;
        }
        
        int[] degree = new int[n];
        
        for(int i = 0; i < n; i++){
            graph.add( new ArrayList<Integer>() );
        }
        
        for(int i = 0; i < edges.length; i++){
            graph.get( edges[i][0] ).add( edges[i][1]);
            graph.get( edges[i][1] ).add( edges[i][0]);
            degree[ edges[i][0] ]++;
            degree[ edges[i][1] ]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < n; i++){
            if( degree[i] == 0 ){
                return result;
            }else if( degree[i] == 1 ){
                q.offer(i);
            }
        }
        
        while( !q.isEmpty() ){
            result = new ArrayList<Integer>();
            int size = q.size();
            
            for(int j = 0; j < size; j++ ){
                int cur = q.poll();
                result.add( cur );
                degree[ cur ]--;
                for(int i = 0; i < graph.get( cur ).size(); i++){
                    int next = graph.get( cur ).get(i);
                    if( degree[next] == 0 ){
                        continue;
                    }
                    if( degree[ next] == 2 ){
                        q.offer( next );
                    }
                    
                    degree[ next]--;
                }
            }
        }
        
        return result;
    }
}
