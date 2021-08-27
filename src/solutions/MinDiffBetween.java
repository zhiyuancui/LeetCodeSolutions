package solutions;

/**
 * 1981 Minimize the Difference Between Target and Chosen Elements
 */
public class MinDiffBetween {
    public int minimizeTheDifference(int[][] mat, int target) {
        int row = mat.length;

        boolean[][] dp = new boolean[row][target];
        int large = Integer.MAX_VALUE;

        for(int i : mat[0]) {
            if(i >= target) {
                large = large > i ? i : large;
            } else {
                dp[0][i] = true;
            }
        }

        for(int i = 1; i < row; i++) {
            int last_large = Integer.MAX_VALUE;

            for(int num : mat[i]) {
                for(int j = 0; j < target; j++) {
                    if(dp[i-1][j]) {
                        if(j + num >= target) {
                            last_large = last_large > j+num ? j+num : last_large;
                        } else {
                            dp[i][j+num] = true;
                        }
                    }
                }
                //如果之前就已经加超了
                if(large != Integer.MAX_VALUE)
                    last_large = last_large > large+num ? large+num : last_large;
            }

            large = last_large;
        }

        int result = Math.abs(large - target);

        for(int i = 0; i < target; i++) {
            if(dp[row-1][i]) {
                result = Math.min(result, Math.abs(target - i));
            }
        }

        return result;
    }
}
