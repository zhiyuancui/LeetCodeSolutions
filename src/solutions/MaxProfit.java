package solutions;

import java.util.Arrays;

public class MaxProfit {

	/**
	 * Best Time to Buy and Sell Stock II
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		int profit = 0;
        if( prices == null || prices.length == 0 )
        {
            return 0;
        }
        
        for( int i = 1; i < prices.length; i++ )
        {
            int diff = prices[i] - prices[ i - 1 ];
            if( diff > 0 )
            {
                profit += diff;
            }
        }
        
        return profit;
    }
	
	/**
	 * Best Time to Buy and Sell Stock I
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        
        if( prices == null || prices.length == 0)
        {
            return 0;
        }
        
        int profit = 0;
        
        int min = prices[0];
        
        for(int p : prices)
        {
            min = Math.min(min, p);
            profit = Math.max(profit, p - min);
        }
        
        return profit;
    }
	

	/**
	 * Best Time to Buy and Sell Stock III
	 * @param prices
	 * @return
	 */
	public int maxProfit3(int[] prices) {
        
        if( prices == null || prices.length == 0 )
        {
            return 0;
        }
        
        int[] f = new int[ prices.length ];
        int[] g = new int[ prices.length ];
        
        
        int valley = prices[0];
        for(int i = 1; i < prices.length; i++ )
        {
            valley = Math.min( valley, prices[i]);
            f[i] = Math.max(f[i-1], prices[i] - valley );
        }
        
        int peak = prices[ prices.length - 1 ];
        for(int i = prices.length - 2; i >= 0; i--){
            peak = Math.max( peak, prices[i] );
            g[i] = Math.max( g[i+1], peak - prices[i]);
        }
        
        int max = -1;
        for(int i = 0; i < prices.length; i++)
        {
            max = Math.max(max, f[i] + g[i] );
        }
        
        return max;
    }
	
	
	/**
	 * Best time to Buy and Sell Stock IV
	 * 
	 * Reference to https://leetcode.com/discuss/62026/clean-java-dp-solution-with-comment
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit4(int k, int[] prices) {
		int n = prices.length;
	    if (n <= 1)
	        return 0;

	    //if k >= n/2, then you can make maximum number of transactions.
	    if (k >=  n/2) {
	        int maxPro = 0;
	        for (int i = 1; i < n; i++) {
	            if (prices[i] > prices[i-1])
	                maxPro += prices[i] - prices[i-1];
	        }
	        return maxPro;
	    }

	    int[][] dp = new int[k+1][n];
	    for (int i = 1; i <= k; i++) {
	        int localMax = dp[i-1][0] - prices[0];
	        for (int j = 1; j < n; j++) {
	            dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
	            localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
	        }
	    }
	    return dp[k][n-1];
    }
	
	/**
	 * Reference to: https://leetcode.com/discuss/71354/share-my-thinking-process
	 * Best Time to Buy and Sell Stock with Cooldown
	 * @param prices
	 * @return
	 */
	public int maxProfit5(int[] prices) {
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
	    for (int price : prices) {
	        prev_buy = buy;
	        buy = Math.max(prev_sell - price, prev_buy);
	        prev_sell = sell;
	        sell = Math.max(prev_buy + price, prev_sell);
	    }
	    return sell;
    }
	
	public static void main(String[] args){
		MaxProfit m = new MaxProfit();
		int[] prices = {3,2,1,4,5,6};
		m.maxProfit4(2, prices);
	}
}
