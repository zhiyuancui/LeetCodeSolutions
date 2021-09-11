package solutions;

/**
 * 309 Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length <= 1 ) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] cool = new int[prices.length];

        buy[0]= -prices[0];
        sell[0] = 0;
        cool[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(cool[i-1]-prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
            cool[i] = Math.max(sell[i-1], Math.max(buy[i-1], cool[i-1]));
        }

        return Math.max( sell[prices.length - 1 ], Math.max(buy[prices.length - 1 ],cool[prices.length - 1 ]) );
    }
}
