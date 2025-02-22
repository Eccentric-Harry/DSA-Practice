class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n]; // Length of LIS ending at each index
        int[] count = new int[n]; // Number of LIS ending at each index
        Arrays.fill(dp, 1); // Minimum LIS length is 1
        Arrays.fill(count, 1); // Minimum LIS count is 1

        int maxLen = 1; // Maximum length of LIS
        int totalCount = 0; // Total count of LIS

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Inherit the count
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j]; // Add additional ways
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                totalCount += count[i];
            }
        }

        return totalCount;
    }
}
