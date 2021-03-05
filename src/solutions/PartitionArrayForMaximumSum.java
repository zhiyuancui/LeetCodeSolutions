package solutions;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int[] dp = new int[arr.length];

        int max = arr[0];
        for(int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i+1);
        }

        for(int i = k; i < arr.length; i++) {
            max = arr[i];
            for(int j = 1; j <= k; j++) {
                max = Math.max(max, arr[i-j+1]);
                dp[i] = Math.max(dp[i], dp[i-j] + max *j);
            }
        }

        return dp[arr.length-1];
    }
}
