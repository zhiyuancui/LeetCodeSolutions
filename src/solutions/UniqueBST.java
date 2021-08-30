package solutions;


/**
 * 96 Unique Binary Search Trees
 */
public class UniqueBST {
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;
    
        for(int i=2; i<=n; ++i) {
    	    for(int j=1; j<=i; ++j) {
    		    dp[i] += dp[j-1] * dp[i-j];
    	    }
        }

        return dp[n];
    }
}
