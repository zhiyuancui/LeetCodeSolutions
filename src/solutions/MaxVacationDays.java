package solutions;

public class MaxVacationDays {

	int max = 0, N = 0, K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);
        
        return max;
    }
    
    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) {
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
            }
        }
    }

    public int maxVacationDays2(int[][] flights, int[][] days) {
        if(flights == null || days == null) {
            return 0;
        }

        int n = flights.length;
        int k = days[0].length;

        int[] dp = new int[n];

        boolean[] reached = new boolean[n];
        reached[0] = true;

        int week = 0;

        while(week < k) {
            int[] tmp = dp.clone();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(flights[i][j] == 1 || i == j) {
                        if(!reached[i]) continue;
                        reached[j] = true;
                        tmp[j] = Math.max(tmp[j], dp[i] + days[j][week]);
                    }
                }
            }
            dp = tmp;
            week++;
        }

        int max = 0;

        for(int d : dp) {
            max = Math.max(max, d);
        }

        return max;
    }
}
