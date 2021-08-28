package solutions;

import java.util.PriorityQueue;

public class UglyNumber {
	
	public boolean isUgly(int num) {
        
        if( num <= 0 )
        {
            return false;
        }
        
        if( num == 1)
        {
            return true;
        }
        
        if( num % 2 == 0 )
        {
            return isUgly( num / 2 );
        }
        else if( num % 3 == 0 )
        {
            return isUgly( num / 3 );
        }
        else if( num % 5 == 0 )
        {
            return isUgly( num / 5);
        }
        else
        {
            return false;
        }
    }
	
	/**
	 * Ugly Number II
	 * Ugly number is the number which smaller than it, multiply primes
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        if( n == 1 ){
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1,p3=1,p5=1;
        for(int i =2; i <=n; i++){
            dp[i] = Math.min(2*dp[p2], Math.min(3*dp[p3], 5*dp[p5]));
            if( dp[i] == 2*dp[p2] ){
                p2++;
            }
            if( dp[i] == 3*dp[p3] ){
                p3++;
            }
            if( dp[i] == 5*dp[p5] ){
                p5++;
            }
        }
        
        return dp[n];
    }
}
