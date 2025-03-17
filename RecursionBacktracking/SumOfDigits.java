import java.util.*;
public class SumOfDigits{
    public static void main(String[] args){
        int n = 352668;
        System.out.println(helper(n));
    }
    private static int helper(int n){
        if(n == 0) return 0;
        return n%10 + helper(n/10);
    }
}