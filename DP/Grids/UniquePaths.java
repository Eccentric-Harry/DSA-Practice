import java.util.*;
public class UniquePaths{
    public static int uniquePaths(int m, int n) {
        // return helper(m,n,0,0);
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }
        return memoization(m,n,m-1,n-1,dp);

    }
    public static int helper(int m, int n, int row, int col){
        if(row == m-1 && col== n-1){
            return 1;
        }
        if(row > m-1 || col > n-1){
            return 0;

        }
        return helper(m,n,row+1, col) + helper(m,n,row, col+1);
    }
    public static void main(String[] args){
        int m = 4;
        int n = 7;
        System.out.println(uniquePaths(m,n));
    }
    // ise me DP me kaise convert karu?
    public static int memoization(int m, int n,int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        dp[row][col] = memoization(m,n,row-1, col,dp) + memoization(m,n,row,col-1,dp);
        return dp[row][col];
    }
}