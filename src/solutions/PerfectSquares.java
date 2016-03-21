package solutions;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
	public int numSquares(int n) {
        List<Integer> dp = new ArrayList<Integer>();
        dp.add(0);
        
        if( dp.size() >= n + 1 ){
            return dp.get(n);
        }
        
        while( dp.size() <= n + 1 ){
            int temp = Integer.MAX_VALUE;
            
            for(int j = 1; j * j <= dp.size(); j++ ){
                temp = Math.min( temp, dp.get( dp.size() - j *j) + 1);
            }
            dp.add( temp );
        }
        
        return dp.get(n);
    }
}
