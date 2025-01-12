import java.util.*;
public class MinimumFallingathSum{
    public static  int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int currMin = helper(matrix,n-1,i);
            ans = Math.min(ans,currMin);
        }
        return ans;
    }
    private static int helper(int[][] grid, int row, int col){
        if (col < 0 || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(row == 0){
            return grid[row][col];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        up =   helper(grid,row-1,col);
        left =  helper(grid,row-1, col-1);
        right =  helper(grid,row-1, col+1);

        return grid[row][col] + Math.min(up, Math.min(left,right));
    }

}

