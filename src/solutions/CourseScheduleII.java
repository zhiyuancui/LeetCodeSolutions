package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule II
 * @return
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<Integer>();

        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i = 0; i < numCourses; i++){
            List<Integer> l = new ArrayList<Integer>();
            graph.add(l);
        }

        int[] indegree = new int[ numCourses ];

        for( int[] edge : prerequisites ){
            graph.get( edge[1] ).add( edge[0] );
            indegree[ edge[0] ]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < numCourses; i++){
            if( indegree[i] == 0 ){
                q.offer(i);
            }
        }

        while( !q.isEmpty() ){
            int cur = q.poll();
            result.add( cur );
            for(int i : graph.get( cur ) ){
                indegree[i]--;
                if( indegree[i] == 0 ){
                    q.offer(i);
                }
            }
        }

        if( result.size() != numCourses ){
            return new int[0];
        }

        int[] res = new int[ numCourses ];
        for(int i = 0 ; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }
}
