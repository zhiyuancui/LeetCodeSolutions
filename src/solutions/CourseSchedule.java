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
