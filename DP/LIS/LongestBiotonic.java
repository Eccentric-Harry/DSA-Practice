class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        if (n == 0 || nums.length == 0) {
            return 0; // Handle edge cases
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Compute LIS ending at each index
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp1[i] < 1 + dp1[j]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        // Compute LIS starting from each index (reversed)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) { // Only consider `j > i` for efficiency
                if (nums[i] > nums[j] && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        // Find the maximum bitonic sequence length
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp1[i] + dp2[i] - 1, max); // `-1` to avoid double-counting
        }

        return max;
    }
}
