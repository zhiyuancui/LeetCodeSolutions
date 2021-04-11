package solutions;

public class PaintHouse {

	/**
	 * 
	 * Paint House II
	 * 
	 * There are a row of n houses, each house can be painted with one of the k colors. 
	 * The cost of painting each house with a certain color is different. 
	 * You have to paint all the houses such that no two adjacent houses have the same color.
	 * The cost of painting each house with a certain color is represented by a n x k cost matrix. 
	 * For example, costs[0][0] is the cost of painting house 0 with color 0; 
	 * costs[1][2] is the cost of painting house 1 with color 2, and so on... 
	 * Find the minimum cost to paint all houses.
	 * 
	 * Reference to https://leetcode.com/discuss/54415/ac-java-solution-without-extra-space
	 * 
	 * @param costs
	 * @return
	 */
		public int minCostII(int[][] costs) {
			if(costs == null || costs.length == 0) {
				return 0;
			}

			int n = costs.length;
			int k = costs[0].length;

			Integer leastMin = null;
			Integer secondMin = null;

			int[][] dp = new int[n][k];
			for(int i = 0; i < k; i++) {
				dp[0][i] = costs[0][i];
				if(leastMin == null || dp[0][i] < dp[0][leastMin]) {
					secondMin = leastMin;
					leastMin = i;
				} else if(secondMin == null || dp[0][i] < dp[0][secondMin]) {
					secondMin = i;
				}
			}

			for(int i = 1; i < n; i++) {
				int leastIndex = leastMin;
				int secondIndex = secondMin;

				leastMin = null;
				secondMin = null;

				for(int j = 0; j < k; j++) {
					if( j != leastIndex) {
						dp[i][j] = dp[i-1][leastIndex] + costs[i][j];
					} else {
						dp[i][j] = dp[i-1][secondIndex] + costs[i][j];
					}

					if(leastMin == null || dp[i][j] < dp[i][leastMin]) {
						secondMin = leastMin;
						leastMin = j;
					} else if(secondMin == null || dp[i][j] < dp[i][secondMin]) {
						secondMin = j;
					}
				}
			}

			for(int i = 0; i < n; i++) {
				for(int j =0; j < k; j++) {
					System.out.print(dp[i][j] +" ,");
				}
				System.out.println();
			}
			return dp[n-1][leastMin];
		}

	
	
	/**
	 * Paint House
	 * 
	 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
	 * The cost of painting each house with a certain color is different. 
	 * You have to paint all the houses such that no two adjacent houses have the same color.
	 * 
	 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
	 * 
	 * For example, 
	 * costs[0][0] is the cost of painting house 0 with color red; 
	 * costs[1][2] is the cost of painting house 1 with color green, and so on... 
	 * Find the minimum cost to paint all houses.
	 * 
	 * Note:
	 * 
	 * All costs are positive integers.
	 * 
	 * 
	 * Reference to : https://leetcode.com/discuss/51721/simple-java-dp-solution
	 * 
	 * @param costs
	 * @return
	 */
	public int minCost(int[][] costs) {
		if(costs==null||costs.length==0){
	        return 0;
	    }
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
	    }
	    int n = costs.length-1;
	    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}
