package solutions;

import java.util.Arrays;

/**
 * Coin Change
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]  = 0;
        for(int coin : coins) {
            if(coin > amount) {
                break;
            }
            dp[coin] = 1;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length && coins[j] <= i; j++) {
                if(dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }


        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
