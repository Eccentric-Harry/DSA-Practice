public class ClimbStairs{
    public static int countWays(int steps){
        int[] dp = new int[steps+1];
        return helper(steps, dp);
    }
    public static int helper(int steps, int[] dp){
        if(steps <= 1){
            return 1;
        }
        if(dp[steps]!=0){
            return dp[steps];
        }
        dp[steps] = helper(steps-1,dp) + helper(steps-2,dp);
        return dp[steps];
    }
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        int steps = 5;
        int ways = countWays(steps);
        System.out.println(ways);
        S
    } 
}