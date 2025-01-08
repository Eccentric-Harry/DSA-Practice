import java.util.Arrays;
public class HouseRobberII{
    public static int rob(int[] nums){
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        if(nums.length == 0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return helper(nums,0,dp);
    }
    public static int helper(int[] nums, int index, int[] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        
            int pickCurrent = nums[index] + helper(nums,index+2,dp);
            int skipCurrent = helper(nums,index+1,dp);
            dp[index] = Math.max(pickCurrent, skipCurrent);
        
        return dp[index];
    }
    public static void main(String[] args){
        int[] nums = {10,20,30,10};
        System.out.println(rob(nums));
    }
}