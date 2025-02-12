class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k + 1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,prices,n, k, dp);
    }
    int helper(int index, int transaction, int[] prices, int n, int k, int[][] dp){
        if(index==n || transaction == 2*k){
            return 0;
        }
        if(dp[index][transaction] !=-1){
            return dp[index][transaction];
        }

        if(transaction%2==0){
            return dp[index][transaction] =   Math.max(-prices[index] + helper(index+1, transaction+1, prices,n,k, dp), 0+ helper(index+1, transaction, prices, n, k, dp));
        }else{
            return dp[index][transaction] = Math.max((prices[index] + helper(index+1, transaction+1,prices,n,k, dp)), 0 + helper(index+1, transaction, prices,n,k, dp));
        }
    }
}