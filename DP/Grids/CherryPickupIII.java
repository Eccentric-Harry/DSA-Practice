import java.util.*;
public class CherryPikupIII{
    public int solve(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        for (int aliceCol = 0; aliceCol < m; aliceCol++) {
            for (int bobCol = 0; bobCol < m; bobCol++) {
                if (aliceCol == bobCol) {
                    dp[n - 1][aliceCol][bobCol] = grid[n - 1][aliceCol];
                } else {
                    dp[n - 1][aliceCol][bobCol] = grid[n - 1][aliceCol] + grid[n - 1][bobCol];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) { 
            for (int aliceCol = 0; aliceCol < m; aliceCol++) {
                for (int bobCol = 0; bobCol < m; bobCol++) {
                    int maxChocolates = Integer.MIN_VALUE;
                    for (int dirAlice = -1; dirAlice <= 1; dirAlice++) {
                        for (int dirBob = -1; dirBob <= 1; dirBob++) {
                            int nextAliceCol = aliceCol + dirAlice;
                            int nextBobCol = bobCol + dirBob;
                            if (nextAliceCol >= 0 && nextAliceCol < m && nextBobCol >= 0 && nextBobCol < m) {
                                int currentChocolates = (aliceCol == bobCol) 
                                    ? grid[row][aliceCol] 
                                    : grid[row][aliceCol] + grid[row][bobCol];
                                currentChocolates += dp[row + 1][nextAliceCol][nextBobCol];
                                maxChocolates = Math.max(maxChocolates, currentChocolates);
                            }
                        }
                    }
                    dp[row][aliceCol][bobCol] = maxChocolates;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}
