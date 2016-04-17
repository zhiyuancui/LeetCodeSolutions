package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        List<List<Integer>> course = new ArrayList<List<Integer>>();
        
        int[] map = new int[ numCourses ];
        
        List<Integer> result = new ArrayList<Integer>();
        
        for( int i = 0; i < numCourses; i++ ){
            course.add ( new ArrayList<Integer>() );
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            course.get( prerequisites[i][0] ).add( prerequisites[i][1] );
        }
        
        for( int i = 0; i < numCourses; i++ ){
            if( !dfs( course,i,result,map) ){
                return new int[0];
            }
        }
        
        int[] ans = new int[ result.size() ];
        for(int i = 0; i < result.size(); i++ ){
            ans[i] = result.get(i);
        }
        
        return ans;
    }
    
    public boolean dfs(List<List<Integer>> course, int req, List<Integer> result, int[] map ){
        if( map[req] == 0 ){
            map[ req ] = 1;
            for(int i = 0 ; i < course.get(req).size(); i++ ){
                if( !dfs( course, course.get(req).get(i), result, map) ){
                    return false;
                }
            }
            map[req] = 2;
        }else if( map[req] == 1 ){
            return false;
        }else if( map[req] == 2 ){
            return true;
        }
        result.add( req );
        return true;
    }
}
