import java.util.*;
public class MinimumFallingPathII{
    public static  int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            int currValue = helper(matrix,matrix.length-1,i, dp);
            ans = Math.min(ans , currValue);
        }
        return ans;
    }
    public static int helper(int[][] matrix, int row, int col, int[][] dp){
        if(col < 0 || col >= matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == 0){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up = helper(matrix, row-1,col, dp);
        int left = helper(matrix,row-1, col-1,dp);
        int right = helper(matrix,row-1, col+1,dp);

        dp[row][col] = matrix[row][col] + Math.min(up, Math.min(left, right));
        return dp[row][col];
    }
    // ab ise tabulation me karo.
    public static int tabulation(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            dp[0][i] = grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                up = dp[i-1][j];
                if(j>0) left = dp[i-1][j-1];
                if(j < grid[0].length-1) right = dp[i-1][j+1];

                dp[i][j] =grid[i][j] +  Math.min(up, Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++){
            min = Math.min(min, dp[grid.length-1][i]);
        }
        return min;
    }
}