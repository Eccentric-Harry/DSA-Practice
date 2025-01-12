public class PartitionEqualSum{
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2 != 0){
            return false;
        }
        int partitionSum = sum/2;
        int[][] dp = new int [nums.length][partitionSum+1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, partitionSum,n-1, dp);
    }
    public static boolean helper(int[] nums, int target, int index , int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == 0) return arr[index] == target;

        if(dp[index][target]!=-1){
            return dp[index][target] == 1;
        }
        boolean not_Take = helper(arr, target, index-1, dp);
        boolean take = false;
        if(target >= arr[index]){
            take = helper(arr, target-arr[index], index-1, dp);
        }
        dp[index][target] = (take || not_Take) ? 1 : 0;
        return dp[index][target] == 1;
    }
}