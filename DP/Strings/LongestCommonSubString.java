import java.util.*;
public class LongestCommonSubString{
    public static int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int j = 0; j <= m; j++) dp[0][j] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                boolean match = s1.charAt(i-1) == s2.charAt(j-1);
                if(match){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "abcd";
        System.out.println(longestCommonSubstr(s1,s2));
    }

}