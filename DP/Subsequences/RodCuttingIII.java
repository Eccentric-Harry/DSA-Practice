import java.util.*;
public class RodCuttingIII {
    public static int cutRod(int[] price) {
        int n = price.length;

        // Create a DP table to store the maximum value for each rod length
        int[] dp = new int[n + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) { // Iterate through rod lengths
            for (int j = 0; j < i; j++) { // Iterate through price array
                dp[i] = Math.max(dp[i], price[j] + dp[i - (j + 1)]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value: " + cutRod(price)); 
    }
}
