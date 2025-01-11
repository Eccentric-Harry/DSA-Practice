import java.util.*;
public class MinimumPathSum{
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(grid, m-1, n-1);
    }
    private static int helper(int[][] grid, int row, int col){
        if(row==0 && col ==0){
            // we reached the first index so return it's value.
            return grid[0][0];
        } 
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        int up = helper(grid,row-1,col);
        int left = helper(grid,row,col-1);

        return grid[row][col] + Math.min(up,left);
    }
    public static void main(String[] args){
        int[][] grid = {{1,100},{10,1}};
        System.out.println(minPathSum(grid));
        System.out.println(memoization(grid,grid.length-1, grid[0].length-1));
    }
    // ab me ise dp me kaise convert karu?
    private static int memoization(int[][] grid, int row, int col){
        int[][] dp = new int[grid.length][grid[0].length];
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }

        int up = helper(grid,row-1,col);
        int left = helper(grid,row,col-1);

        dp[row][col] = grid[row][col] + Math.min(up,left);
        return dp[row][col];
    }
}