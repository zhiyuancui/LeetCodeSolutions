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
	
}
