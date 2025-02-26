import java.util.*;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image;
        }
        dfs(image, sr, sc, color, initialColor);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color, int initialColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != initialColor) {
            return;
        }
        image[i][j] = color;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(image, newRow, newCol, color, initialColor);
        }
    }
}