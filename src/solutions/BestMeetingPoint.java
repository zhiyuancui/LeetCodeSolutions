package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 296 Best Meeting Point
 */
public class BestMeetingPoint {

	public int minTotalDistance(int[][] grid) {
		int row = grid.length;
	    int col = grid[0].length;

	    List<Integer> I = new ArrayList<>(row);
	    List<Integer> J = new ArrayList<>(col);

	    for(int i = 0; i < row; i++){
	        for(int j = 0; j < col; j++){
	            if(grid[i][j] == 1){
	                I.add(i);
	                J.add(j);
	            }
	        }
	    }

	    return getMin(I) + getMin(J);
	}

	private int getMin(List<Integer> list){
	    int ret = 0;

	    Collections.sort(list);

	    int i = 0;
	    int j = list.size() - 1;
	    while(i < j){
	        ret += list.get(j--) - list.get(i++);
	    }

	    return ret;
	}
}
