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
	 * @param prices
	 * @return
	 */
	public int maxProfit4(int k, int[] prices) {
        if( k <= 0 || prices == null || prices.length <= 0 ){
            return 0;
        }
        
        if( k > prices.length / 2 ){
            int max = 0;
            for(int i = 0; i < prices.length - 1; i++){
                int diff = prices[i+1] - prices[i];
                max += diff > 0 ? diff : 0;
            }
            return max;
        }else{
            int[] buy = new int[k];
            int[] sell = new int[k];
            
            Arrays.fill( buy, Integer.MIN_VALUE);
            
            for( int price : prices ){
                int tmp = 0;
                for( int i = 0; i < k; i++ ){
                    int buffer = 0;
                    buffer = tmp - price;
                    if( buy[i] < buffer ){
                        buy[i] = buffer;
                    }
                    
                    buffer = buy[i] + price;
                    
                    if( sell[i] < buffer ){
                        sell[i] = buffer;
                    }
                    
                    tmp = sell[i];
                }
            }
            
            return sell[ k - 1 ];
        }
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
}
