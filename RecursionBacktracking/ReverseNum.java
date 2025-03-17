import java.util.*;
public class ReverseNum{
    public static void main(String[] args){
        int n = 346473;
        int[] ans = new int[1];
        helper(n, ans);
        System.out.println(ans[0]);

    }
    private static void helper(int n, int[] ans){
        if(n == 0) return;
        ans[0] = ans[0]*10 + n%10;
        helper(n/10, ans);
    }
}