package solutions;

/**
 * 983 Minimum Cost For Tickets
 */
public class MinimumCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];

        int[] dp = new int[maxDay + 1];

        dp[0] = 0;

        int counter = 0;

        for(int i = 1; i <= maxDay; i++) {
            if(days[counter] == i) {
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
                counter++;
            } else {
                dp[i] = dp[i-1];
            }
        }

        return dp[maxDay];
    }
}
