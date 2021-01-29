package solutions;

import java.util.Arrays;

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
	
	/**
	 * Coin Change II
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    int solution = 0;
    public int change2(int amount, int[] coins) {
        if(amount == 0) {
            return 1;
        }
        if(coins == null || coins.length == 0) {
            return 0;
        }

        backtrack(coins, amount,0);
        return solution;
    }

    private void backtrack(int[] coins, int amount, int pos) {
        if(amount <= 0) {
            if(amount == 0) {
                solution++;
            }
            return;
        }

        for(int i = pos; i < coins.length; i++) {
            if(coins[i] <= amount) {
                backtrack(coins, amount-coins[i], i);
            }
        }
    }
}
