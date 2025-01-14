// Paartition Array into two Arrays to minimize the sum difference;

import java.util.*;
public class MinSumPartition{
    public int minimumDifference(int[] nums) {
        
    }
    public static int isSubsetSum(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], false);
        }
        return helper(nums,nums.length-1,target,dp);
    }
    public static int helper(int[] nums, int index, int target, int[][] dp){
        for(int i = 0; i <dp.length; i++){
            if(target == 0){
                dp[i][target] = true;
            }
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= target; j++){
                boolean not_Take = dp[i-1][j];
                boolean take = false;
                if(nums[index] <= target){
                    take = dp[i-1][j-arr[i]];
                }

                dp[i][j] = take|| not_Take;
            }
        }
    }
}