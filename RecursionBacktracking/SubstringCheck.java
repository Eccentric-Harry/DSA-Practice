import java.util.*;
public class SubstringCheck {
    public static void main(String[] args) {
        String s1 = "programmingisfun";
        String s2 = "ping";
        boolean isSubstring = helper(s1, s2, 0,0);
        if (isSubstring) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


    private static boolean helper(String s1, String s2, int i, int j) {
        if( j == s2.length()) return true;
        if(i == s1.length()) return false;
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1,s2,i+1, j+1);
        }
        
        return helper( s1, s2, i+1, j);
    }
}
