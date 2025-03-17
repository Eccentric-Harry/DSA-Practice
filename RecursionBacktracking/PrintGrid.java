import java.util.*;
public class PrintGrid{
    public static void main(String[] args){
        int[][] grid =  {{1,3,1},{1,5,1},{4,2,1}};
        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] arr: visited){
            Arrays.fill(arr, -1);
        }
        helper(grid, 0,0, visited);
    }
    private static void helper(int[][] grid, int i, int j, int[][] visited){
        if(i >= grid.length || j >= grid[0].length){
            return;
        }
        if(visited[i][j]==-1){
            visited[i][j] = 1;
            System.out.print(grid[i][j] + " ");
        }
        helper(grid, i, j+1, visited);
        if(j == grid[0].length-1){
            System.out.println();
            helper(grid, i+1, 0, visited);
        }
        
    }
}