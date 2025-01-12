import java.util.*;
public class MazeObstacles{
    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
       
            if(obstacleGrid[0][0] == 1){
                return 0;
            }
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(dp,-1);
        }
        return helper(obstacleGrid,m-1,n-1,dp);
    }
    public static int helper(int[][] obstacleGrid, int row, int col,int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        if( row < 0 || col < 0){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        dp[row][col] =  helper(obstacleGrid,row-1, col,dp) + helper(obstacleGrid, row, col-1,dp);
        return dp[row][col];
    }
    public static void main(String[] args){
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(tabulation(obstacleGrid,3,3));
    }
 public static int tabulation(int[][] obstacleGrid, int m, int n) {
    int[][] dp = new int[m][n];

    // Base case: If the starting cell has an obstacle, there are no paths.
    if (obstacleGrid[0][0] == 1) {
        return 0;
    }

    // Initialize the dp array
    dp[0][0] = 1; // Starting point

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0; // No paths through an obstacle
            } else {
                // Add paths from the top and left, if valid
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
    }

    // The result is in the bottom-right cell
    return dp[m - 1][n - 1];
}

}