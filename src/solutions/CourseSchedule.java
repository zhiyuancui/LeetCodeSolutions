package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	/**
	 * Course Schedule
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if( numCourses <= 0 || prerequisites == null ){
            return true;
        }
        
        int[] degree = new int[ numCourses ];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < prerequisites.length; i++){
            degree[ prerequisites[i][1] ]++;
        }
        
        for(int i = 0; i < degree.length; i++){
            if( degree[i] == 0 ){
                queue.offer(i);
            }
        }
        
        while( !queue.isEmpty() ){
            int x = queue.poll();
            for(int i = 0; i < prerequisites.length; i++){
                if( x == prerequisites[i][0] ){
                    degree[prerequisites[i][1]]--;
                    if(degree[prerequisites[i][1]] == 0 ){
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        
        for(int i = 0; i < degree.length; i++){
            if( degree[i] != 0 ){
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
        return new int[2];
    }
}
