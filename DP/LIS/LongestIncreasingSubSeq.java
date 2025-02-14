import java.util.*;
public class LongestIncreasingSubSeq{
    public static int len(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <=n; i++){
            dp[n][i] = 0;
        }
        for(int i = n-1; n >=0 ;i--){
            for(int j = i-1; j >= -1; j--){
                int take = 0;
                if(j == -1 || nums[i] > nums[j]){
                    take = 1 + dp[i+1][i+1];
                }
                notTake = dp[i+1][j+1];
                dp[i][j+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int take = 0;
                if (j == -1 || nums[i] > nums[j]) {
                    take = 1 + next[i + 1];
                }
                int notTake = next[j + 1]; 
                curr[j + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }
}