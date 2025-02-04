import java.util.*;
public class PrintLCS {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Helper function to backtrack and collect all LCS
        Set<String> lcsSet = new HashSet<>();
        collectAllLCS(s, t, n, m, dp, new StringBuilder(), lcsSet);

        // Convert set to list and sort lexicographically
        List<String> result = new ArrayList<>(lcsSet);
        Collections.sort(result);

        return result;
    }

    private void collectAllLCS(String s, String t, int i, int j, int[][] dp, StringBuilder current, Set<String> lcsSet) {
        // Base case: If either string is exhausted
        if (i == 0 || j == 0) {
            lcsSet.add(current.reverse().toString());
            current.reverse(); // Reverse back for other recursive calls
            return;
        }

        // If characters match, include them in the LCS
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            current.append(s.charAt(i - 1));
            collectAllLCS(s, t, i - 1, j - 1, dp, current, lcsSet);
            current.deleteCharAt(current.length() - 1); // Backtrack
        } else {
            // If not matching, move in the direction of greater value in dp table
            if (dp[i - 1][j] == dp[i][j]) {
                collectAllLCS(s, t, i - 1, j, dp, current, lcsSet);
            }
            if (dp[i][j - 1] == dp[i][j]) {
                collectAllLCS(s, t, i, j - 1, dp, current, lcsSet);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        PrintLCS obj = new PrintLCS();
        String s = "abaaa";
        String t = "baabaca";
        List<String> result = obj.all_longest_common_subsequences(s, t);
        System.out.println(result); // Output: [aaaa, abaa, baaa]
    }
}
