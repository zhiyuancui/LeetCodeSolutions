package solutions;

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
	 * Best Time to Buy and Sell Stock II
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
}
