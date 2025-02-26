class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Item> q = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Item(i, j, 0)); 
                } else if (grid[i][j] == 1) {
                    freshCount++; 
                }
            }
        }
        if (freshCount == 0) return 0;
        int minTime = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            Item current = q.poll();
            int row = current.row;
            int col = current.col;
            int time = current.time;
            minTime = Math.max(minTime, time);
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2; 
                    q.add(new Item(newRow, newCol, time + 1));
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? minTime : -1;
    }
}
class Item {
    int row;
    int col;
    int time;
    public Item(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
