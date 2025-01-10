import java.util.*;
public class UniquePathsII{
    public static int getPaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(m,n,m-1,n-1,dp);
    }
    public static int helper(int m , int n, int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        dp[row][col] =  helper(m,n,row-1,col, dp) + helper(m,n,row,col-1, dp);
        return dp[row][col];
    }
    public static void main(String[] args){
        int[][] dp = tabulation(4,7);
        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(spaceOptimization(4,7));
    }
    public static int[][] tabulation(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0) continue;
                int up = 0;
                int left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp;
    }
    public static int spaceOptimization(int m, int n){
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < m; i++){
            int[] temp = new int[n];
            temp[0] = 1;
            for(int j = 1; j < n; j++){
                temp[j] = dp[j] + temp[j-1];
            }
            dp = temp;
        }
        return dp[n-1];
    }
}