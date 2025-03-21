public class EditDistance{
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <=m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <=n ;i++){
            for(int j = 1; j <=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =  0 + dp[i-1][j-1];
                }else{
                    int insert = 1 + dp[i][j-1];
                    int remove = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(remove, replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String s1 = "HORSE";
        String s2 = "ROS";
        System.out.println(minDistance(s1, s2));
    }
}