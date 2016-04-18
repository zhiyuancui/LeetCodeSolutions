package solutions;


public class PerfectSquares {
	public int numSquares(int n) {
        if( n <= 0 ){
			return 0;
		}
		
		int[] dp = new int[ n + 1 ];
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++){
		    int temp = Integer.MAX_VALUE;
			for(int j = 1; j *j <= i ; j++ ){
				temp = Math.min(temp, dp[ i - j*j ] + 1 );
			}
			dp[i] = temp;
		}
		
		
		return dp[n];
    }
}
