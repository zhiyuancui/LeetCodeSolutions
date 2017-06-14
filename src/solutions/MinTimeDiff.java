package solutions;

import java.util.List;
import java.util.stream.Stream;

public class MinTimeDiff {
	public int findMinDifference(List<String> timePoints) {
	    
		boolean[] bucket = new boolean[24*60];
        
        for(String time: timePoints){
            int[] times = Stream.of( time.split(":") ).mapToInt(Integer::parseInt).toArray();
            int h = times[0];
            int m = times[1];
            if( bucket[ h*60 + m ] ){
                return 0;
            }
            bucket[h*60 + m ] = true;
        }
        
        int min = Integer.MAX_VALUE;
        int prev = 0;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for(int i = 0; i < bucket.length; i++){
            if( bucket[i] ){
                if( first != Integer.MAX_VALUE ){
                    min = Math.min(min, i-prev);
                }
                first = Math.min(first,i);
                last = Math.max(last,i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24*60 - last + first));
        return min;
        
	}
}
