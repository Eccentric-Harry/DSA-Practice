import java.util.*;

public class KnapstackIII{
    public static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;

        int[][] dp = new int[n][capacity + 1];

        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = (wt[0] <= j) ? val[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int notPick = dp[i - 1][j]; 
                int pick = 0;
                if (j >= wt[i]) {
                    pick = val[i] + dp[i - 1][j - wt[i]]; 
                }
                dp[i][j] = Math.max(pick, notPick); 
            }
        }

        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        int capacity = 4;
        int val[] = {1, 2, 3}, wt[] = {4, 5, 1};
        System.out.println(knapSack(capacity, val, wt));
    }
}
