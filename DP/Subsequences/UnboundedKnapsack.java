import java,util.*;
public class UnboundedKnapsack{
    public static int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return helper(val, wt, capacity, val.length-1, dp);
    }
    private static int helper(int[] val, int[] wt, int capacity, int index, int[][] dp){
        if(index == 0){
            if(wt[index]<=capacity){
                return (capacity/wt[index]) * val[index];
            }else{
                return 0;
            }
        }
        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int notPick = 0 + helper(val , wt , capacity, index-1);
        int pick = 0;
        if(wt[index] <= capacity){
            pick = val[index] + helper(val, wt, capacity-wt[index], index);
        }
        dp[index][capacity] = Math.max(notPick, pick);
        return dp[index][capacity];
    }
}