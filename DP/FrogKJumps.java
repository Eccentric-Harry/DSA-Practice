public class FrogKJumps {
    public int minimizeCost(int k, int[] arr) {
        return jumps(arr, arr.length - 1, k);
    }
    private int jumps(int[] arr, int N, int k) {
        if (N == 0) {
            return 0;
        }
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (N - i >= 0) {
                int jumpEnergy = jumps(arr, N - i, k) + Math.abs(arr[N] - arr[N - i]);
                minEnergy = Math.min(minEnergy, jumpEnergy);
            }
        }
        return minEnergy;
    }
    // using tabualtion DP
    public int minimizeCost(int k, int[] arr) {
        int N = arr.length; // Total number of stairs
        int[] dp = new int[N]; // DP array to store minimum energy to reach each stair
        dp[0] = 0; // Base case: no energy needed to stay on the first stair

        // Fill the DP array
        for (int i = 1; i < N; i++) {
            int minEnergy = Integer.MAX_VALUE;

            // Check all possible jumps within range [1, k]
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) { // Ensure the jump stays within bounds
                    int jumpEnergy = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minEnergy = Math.min(minEnergy, jumpEnergy);
                }
            }
            dp[i] = minEnergy; // Store the minimum energy for stair `i`
        }

        return dp[N - 1]; // Return the minimum energy to reach the last stair
    }
}
