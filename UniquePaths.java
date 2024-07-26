import java.util.Arrays;
class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i<m; i++){
            System.out.println(Arrays.toString(memo[i]));
        }
        return countPaths(0, 0, m, n, memo);
    }
    public static int countPaths(int a, int b, int m, int n, int[][] memo) {
        if (a == m - 1 && b == n - 1) {
            return 1;
        }
        if (a >= m || b >= n) {
            return 0;
        }
        if (memo[a][b] != 0) {
            return memo[a][b];
        }
        memo[a][b] = countPaths(a, b + 1, m, n, memo) + countPaths(a + 1, b, m, n, memo);
        return memo[a][b];
    }
    public static void main(String[] args){
        System.out.println(uniquePaths(3,7));
    }
}
