import java.util.*;
public class Solution{
    public int numIslands(char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        for(int i = 0; i < rows, i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void bfs(char[][] grid, boolean[][] visited, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j] = true;

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int currRow = p.i;
            int currCol = p.j;
            for(int[] dir: directions){
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if(newRow >= 0 && newRow< grid.length && newCol >=0 && newCol < grid[0].length && grid[newRow][newCol] == "1" && !visited[newRow][newCol]){
                    q.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

}
class Pair{
    int i;
    int j;
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
