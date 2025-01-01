public class Fibonacci{
    public static int func(int n){
        if(n <= 1){
            return n;
        }
        return func(n-2)+func(n-1);
    }
    // memoization
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
        seq[n] = helper(n-1, seq) + helper(n-2, seq);
        return seq[n];  
    }
    public static void main(String[] args){
        int n = 9;
        System.out.println(memo(n));
    }
}