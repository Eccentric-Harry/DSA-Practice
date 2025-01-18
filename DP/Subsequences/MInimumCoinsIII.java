import java.util*;
public class MinimumCoinsIII{
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MAX_VALUE;
                if (j >= coins[i] && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    pick = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}