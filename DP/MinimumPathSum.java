import java.util.*;
public class MinimumPathSum{
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(grid, m-1,n-1);
    }
    public static int helper(int[][] grid, int row,int col){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        int up = helper(grid, row-1,col);
        int left = helper(grid, row, col-1);

        return grid[row][col] + Math.min(up,left);
    }
    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}