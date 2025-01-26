class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0; 
        int left = 0;   
        int maxFreq = 1;
        for (int right = 0; right < n; right++) {
            if (right > 0) {
                total += (long) (nums[right] - nums[right - 1]) * (right - left);
            }
            while (total > k) {
                total -= nums[right] - nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}
©leetcode