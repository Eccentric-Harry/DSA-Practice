import java.util.*;
public class SubsetSum {
    public static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: A sum of 0 is always achievable
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: Only the first element can form its own sum
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // Exclude the current element
                boolean notTake = dp[i - 1][j];

                // Include the current element (if it's not larger than the current target)
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = take || notTake;
            }
        }

        // The result is whether we can form the target sum using all elements
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int target = 5;

        System.out.println(isSubsetSum(arr, target)); // Output: true
    }
}
