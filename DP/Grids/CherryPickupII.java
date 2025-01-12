import java.util.*;
public class CherryPickupII{
 public  int solve(int n, int m, int grid[][]) {
        
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,0,m-1,grid,dp);

    }
    public int helper(int row, int aliceCol, int bobCol, int[][] grid, int[][][] dp ){
        if(aliceCol < 0 || aliceCol > grid[0].length-1 || bobCol < 0 || bobCol > grid[0].length-1){
            return Integer.MIN_VALUE;
        }
        if(row == grid.length-1){
            if(bobCol != aliceCol){
                return grid[row][aliceCol] + grid[row][bobCol];
            }else{
                return grid[row][aliceCol];
            }
        }
        if(dp[row][aliceCol][bobCol]!=-1){
            return dp[row][aliceCol][bobCol];
        }
        int maxi = 0;
        for(int dirAlice = -1; dirAlice <= +1; dirAlice++){
            for(int dirBob = -1; dirBob <= +1; dirBob++){
                if(bobCol!=aliceCol){
                    int cherries = grid[row][aliceCol] + grid[row][bobCol] + helper(row+1,aliceCol+dirAlice,bobCol+dirBob, grid,dp);
                    maxi = Math.max(maxi,cherries);
                }else{
                    int cherries = grid[row][bobCol] + helper(row+1,aliceCol+dirAlice,bobCol+dirBob, grid, dp);
                    maxi = Math.max(maxi,cherries);
                }
            }
        }
        dp[row][aliceCol][bobCol] = maxi;
        return maxi;
    }
}