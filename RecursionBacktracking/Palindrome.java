import java.util.*;
public class Palindrome{
    public static void main(String[] args){
        String s = "racecar";
        boolean isPalindrome =  helper(s, 0, s.length()-1);
        if(isPalindrome) System.out.println(1);
        else System.out.println(0);

    }
    private static boolean helper(String s, int start, int end){
        if(start > end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;
        return helper(s, start+1, end-1);
    }
}