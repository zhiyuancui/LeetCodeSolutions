package solutions;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if( coins == null || coins.length == 0 || amount < 0 ){
            return -1;
        }
        
        int[] solution = new int[amount + 1];
        solution[0] = 0;
        
        for(int coin : coins ){
            if( coin > amount ){
                break;
            }
            solution[ coin ] = 1;
        }
        
        for(int i = 1; i <= amount; i++){
            if( solution[i] == 0 ){
                solution[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if( coins[j] <= i && solution[i-coins[j]] != Integer.MAX_VALUE ){
                    solution[i] = Math.min( solution[i], solution[ i - coins[j]] + 1);
                }
            }
        }
        
        return solution[amount] == Integer.MAX_VALUE ? -1: solution[amount];
    }
}
