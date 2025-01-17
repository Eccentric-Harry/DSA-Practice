import java.util.*;
public class MinimumCoinsII{
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int res = helper(coins, amount, coins.length-1, dp);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
    public static int helper(int[] coins, int target, int index, int[][] dp){
        if(index == 0){
            if(target%coins[index] == 0){
                return target/coins[index];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[index][amount] !=-1){
            return dp[index][amount];
        }
        int notPick = helper(coins,target,index-1,dp);
        int pick = Integer.MAX_VALUE;
        if(target >= coins[index]){
            int subResult = helper(coins, target - coins[index], index-1, dp);
            if(subResult!=Integer.MAX_VALUE){
                pick = 1+subResult;
            }
        }
        dp[index][target] = Math.min(pick, notPick);
        return dp[index][target];
    }
}