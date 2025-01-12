import java.util.*;
public class CherryPickup{
    public  int solve(int n, int m, int grid[][]) {
        return helper(0,0,m-1,grid);
    }
    public int helper(int row, int aliceCol, int bobCol, int[][] grid){
        if(aliceCol < 0 || aliceCol > m-1 || bobCol < 0 || bobCol > m-1){
            return Integer.MIN_VALUE;
        }
        if(row == n-1){
            if(bobCol != aliceCol){
                return grid[row][aliceCol] + grid[row][bobCol];
            }else{
                return grid[row][aliceCol];
            }
        }
        int maxi = 0;
        for(int dirAlice = -1; dirAlice <= +1; dirAlice++){
            for(int dirBob = -1; dirBob <= +1; dirBob++){
                if(bobCol!=aliceCol){
                    int cherries = grid[row][aliceCol] + grid[row][bobCol] + helper(row+1,aliceCol+dirAlice,bobCol+dirBob, grid);
                    maxi = Math.max(maxi,cherries);
                }else{
                    int cherries = grid[row][bobCol] + helper(row+1,aliceCol+dirAlice,bobCol+dirBob, grid);
                    maxi = Math.max(maxi,cherries);
                }
            }
        }
        return maxi;
    }
}