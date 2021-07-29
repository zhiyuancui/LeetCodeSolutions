package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 207 Course Schedule
 */
public class CourseSchedule {

	/**
	 * Course Schedule
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
        
        for(int[] requisite: prerequisites) {
            indegree[ requisite[0] ] ++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < indegree.length; i++) {
            if( indegree[i] == 0 ) {
                queue.offer(i);
            }
        }
        
        
        while( !queue.isEmpty() ) {
            int course = queue.poll();
            for(int[] requisite : prerequisites) {
                if( requisite[1] == course ) {
                    indegree[ requisite[0] ] --;
                    if( indegree[ requisite[0] ] == 0 ) {
                        queue.offer( requisite[0] );
                    }
                }
            }
        }
        
        for(int degree : indegree ) {
            if( degree != 0 ) {
                return false;
            }
        }
        
        return true;
    }
	
	
	/**
	 * Course Schedule II
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
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
	
	/**
	 * Course Schedule III
	 * @param courses
	 * @return
	 */
	public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]); 
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for (int[] c:courses) 
        {
            time+=c[0]; 
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); 
        }        
        return pq.size();
    }
}
