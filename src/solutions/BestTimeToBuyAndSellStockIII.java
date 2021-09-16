package solutions;

/**
 * 123 Best Time to Buy and Sell Stock III
 */
public class BestTimeToBuyAndSellStockIII {
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
