class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n-1; i >=1; i--) { 
            for (int j = i+1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]              
                             + dp[k + 1][j]         
                             + arr[i - 1] * arr[k] * arr[j]; 
                    min = Math.min(min, cost); 
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }
}
