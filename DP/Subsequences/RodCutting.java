import java.util.*;
public class RodCutting {
    public static int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(price, n - 1, n, dp);
    }
    public static int helper(int[] price, int index, int targetLength, int[][] dp) {
        if (index == 0) {
            return targetLength * price[0];
        }
        if(dp[index][targetLength]!=-1){
            return dp[index][targetLength];
        }
        int notPick = helper(price, index - 1, targetLength, dp);
        int pick = 0;
        int rodLength = index + 1; 
        if (targetLength >= rodLength) {
            pick = price[index] + helper(price, index, targetLength - rodLength, dp);
        }
        return dp[index][targetLength] = Math.max(pick, notPick);
    }
}
