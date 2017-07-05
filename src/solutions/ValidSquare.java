package solutions;

import java.util.ArrayList;
import java.util.List;

public class ValidSquare {
public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        List<Integer> distances = new ArrayList<Integer>();
        distances.add( getDistance(p1,p2) );
        distances.add( getDistance(p1,p3) );
        distances.add( getDistance(p1,p4) );
        distances.add( getDistance(p2,p3) );
        distances.add( getDistance(p4,p2) );
        distances.add( getDistance(p3,p4) );
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int d : distances) {
            if( d == 0 ) {
                return false;
            }
            min = Math.min(min,d);
            max = Math.max(max,d);
        }
        
        int minCount=0, maxCount = 0;
        
        for(int d : distances) {
            if( d == min ) {
                minCount++;
            } else if( d == max ) {
                maxCount++;
            } else {
                return false;
            }
        }
        
        return minCount == 4 && maxCount == 2;
    }
    
    private int getDistance(int[] p1, int[] p2) {        
        return (int)( Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2 ) );

    }
}
