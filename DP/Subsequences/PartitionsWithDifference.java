import java.util.*;
public class PartitionsWithDifference{
    int countPartitions(int[] arr, int d) {
        int totalSum = 0;
        for(int num: arr){
            totalSum+=num;
        }
        if(totalSum - d < 0 || (totalSum-d)%2!=0) return 0;
        return perfectSum(arr,(totalSum-d)/2);
    }
    public static int perfectSum(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        
        return helper(nums,nums.length-1,target,dp);
    }
    public static int helper(int[] nums, int index, int target, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[index]==0) return 2;
            if(target == 0 || nums[index] == target) return 1;
            return 0;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }

        int notTake = helper(nums,index-1, target,dp);
        int take = 0;
        if(target >= nums[index]){
            take = helper(nums, index-1, target - nums[index], dp);
        }
        dp[index][target] = take+notTake;
        return dp[index][target];
    }
}