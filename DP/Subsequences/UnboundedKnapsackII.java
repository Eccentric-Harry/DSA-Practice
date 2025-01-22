public class UnboundedKnapsackII {
    public static int knapSack(int[] val, int[] wt, int capacity) {
        int[][] dp = new int[val.length][capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = (j / wt[0]) * val[0];
        }

        for (int i = 1; i < val.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                int notPick = dp[i - 1][j]; 
                int pick = 0;
                if (wt[i] <= j) {
                    pick = val[i] + dp[i][j - wt[i]];  // is step pe me mistale karta hu.. so look for it. 
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        // Return the maximum value for the full capacity
        return dp[val.length - 1][capacity];
    }
}
