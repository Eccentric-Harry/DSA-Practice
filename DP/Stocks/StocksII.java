import java.util.*;
public class StocksII{
 public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,1,prices, 0, dp);
    }
    public int helper(int index, int buy, int[] prices, int profit, int[][] dp){
        if(index == prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        if(buy == 1){
            int pick = -prices[index] + helper(index+1,0,prices,profit,dp);
            int notPick = 0 + helper(index+1, 1, prices,profit,dp);
            profit = Math.max(pick,notPick);
        }else{
            int sell = prices[index] + helper(index+1, 1, prices, profit,dp);
            int notSell = 0 + helper(index +1, 0, prices, profit,dp);
            profit = Math.max(sell, notSell);
        }
        return dp[index][buy] = profit;
    }
}
