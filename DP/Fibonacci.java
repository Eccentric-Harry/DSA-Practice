public class Fibonacci{
    // Recursion O(2^n)
    public static int func(int n){
        if(n <= 1){
            return n;
        }
        return func(n-2)+func(n-1);
    }
    // memoization O(N) + {O(n) + O(n)}
    public static int memo(int n){
        int[] seq = new int[n+1];
        return helper(n,seq);
    }
    public static int helper(int n, int[] seq){
        if(n <= 1){
            return n;
        }
        if(seq[n]!=0){
            return seq[n];
        }
        seq[n] = helper(n-1,seq)+ helper(n-2, seq);
        return seq[n];  
    }
    // Tabulation O(N) + O(N) (bottom-up)
    public static int tabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // without extra space
    public static int optimal(int n){
        int prev2 = 0;
        int prev1 = 1;
        if(n<=1){
            return n;
        }
        int sol = 0; 
        for(int i = 2; i <= n; i++){
            sol = prev1+prev2;
            prev2 = prev1;
            prev1 = sol;
        }
        return sol;
    }
    public static void main(String[] args){
        int n = 9;
        System.out.println(optimal(n));
    }
}