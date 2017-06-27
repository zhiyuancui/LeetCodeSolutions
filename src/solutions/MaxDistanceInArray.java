package solutions;

import java.util.List;

public class MaxDistanceInArray {
	public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get( arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> array = arrays.get(i);
            int first = array.get(0);
            int last = array.get( array.size() - 1 );
            result = Math.max( result, Math.abs(first - max ) );
            result = Math.max( result, Math.abs(last - min ) );
            max = Math.max(max, last);
            min = Math.min(min, first);
        }
        
        return result;
    }
}
