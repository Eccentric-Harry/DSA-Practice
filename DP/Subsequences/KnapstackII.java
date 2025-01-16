import java.util.*;
public class KnnapStackII{
    public static int knapSack(int capacity, int val[], int wt[]){
        int[][] dp = new int[val.length][capacity+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(capacity,val,wt,val.length-1,dp);
    }
    public static int helper(int capacity, int[] val, int[] wt, int index, int[][] dp){
        if(index==0){
            dp[index][capacity] = (wt[index] <= capacity) ? val[index] : 0;
        }
        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int notPick = 0 + helper(capacity, val, wt, index-1, dp);
        int pick = 0;
        if(capacity >= wt[index]){
            pick = val[index] + helper(capacity-wt[index], val, wt, index-1, dp);
        }
        return dp[index][capacity] = Math.max(pick,notPick);
    }
    public static void main(String[] args){
        int capacity = 4; int val[] = {1, 2, 3}, wt[] = {4, 5, 1};
        System.out.println(knapSack(capacity,val,wt));
    }
    
}