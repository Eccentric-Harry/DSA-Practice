import java.util.*;
public class Triangle{
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(triangle,0,0,dp);
    }
    public static int helper(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(row >= triangle.size()){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down = helper(triangle, row+1, col, dp);
        int slant = helper(triangle, row + 1, col+1,dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down,slant);
        return dp[row][col];
    }
    // ab ise memoization se kar.
    // ab ise Tabulation se kaise karu?
    public static int tabulation(List<List<Integer>> triangle, int row, int col){
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 0; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(0).size(); j++){
                if(i == 0 && j == 0) dp[0][0] = triangle.get(0).get(0);
                int down = Integer.MAX_VALUE;
                int slant = Integer.MAX_VALUE;
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]); 
            }
        }
        return dp[triangle.size()-1][triangle.size()-1];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return tabulation(triangle);
    }

    public static int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the top of the triangle
        dp[0][0] = triangle.get(0).get(0);

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = Integer.MAX_VALUE;
                int slant = Integer.MAX_VALUE;

                // If coming from directly above
                if (j < triangle.get(i - 1).size()) {
                    down = dp[i - 1][j];
                }

                // If coming from the top-left diagonal
                if (j > 0) {
                    slant = dp[i - 1][j - 1];
                }

                dp[i][j] = triangle.get(i).get(j) + Math.min(down, slant);
            }
        }

        // Find the minimum value in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }

        return minPathSum;
    }
}