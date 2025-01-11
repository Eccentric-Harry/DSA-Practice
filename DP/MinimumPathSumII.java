import java.util.*;
public class MinimumPathSum{
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return memoization(grid, grid.length-1, grid[0].length-1,dp);
    }
    private static int memoization(int[][] grid, int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int up = memoization(grid,row-1,col,dp);
        int left = memoization(grid,row,col-1,dp);

        dp[row][col] = grid[row][col] + Math.min(up,left);
        return dp[row][col];
    }
    // ab me ise tabulation me kaise convert karu?
    public static int tabulation(int[][] grid, int row, int col){
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i==0 && j == 0){
                    dp[0][0] = grid[0][0];
                }
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}