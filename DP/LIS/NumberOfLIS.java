class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n]; 
        int[] count = new int[n]; 
        Arrays.fill(dp, 1); 
        Arrays.fill(count, 1);

        int maxLen = 1;
        int totalCount = 0;

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
