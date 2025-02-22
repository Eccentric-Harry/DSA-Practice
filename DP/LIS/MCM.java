class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Base case: Cost is 0 when multiplying one matrix (diagonal elements)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Iterate over chain lengths
        for (int length = 2; length < n; length++) { // length is the chain length (number of matrices)
            for (int i = 1; i <= n - length; i++) {
                int j = i + length - 1; // Ending index of the chain
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible partitions
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]              // Cost of multiplying matrices from i to k
                             + dp[k + 1][j]         // Cost of multiplying matrices from k+1 to j
                             + arr[i - 1] * arr[k] * arr[j]; // Cost of the resulting matrix multiplication

                    dp[i][j] = Math.min(dp[i][j], cost); // Take the minimum cost
                }
            }
        }

        // Return the minimum cost for the entire chain (1 to n-1)
        return dp[1][n - 1];
    }
}
