import java.util.*;
public class CheckIfEqual{
    public static void main(String[] args){
        String s1 = "HelloHari";
        String s2 = "EccentricHarry";
        if(s1.length()!= s2.length()){
            System.out.println("NOT SAME"); 
            return;
        }
        boolean res = helper(s1, s2, 0);   
        System.out.println(res);                
    }
    private static boolean helper(String s1, String s2, int i){
        
        if( i < 0) return true;
        if(s1.charAt(i)!=s2.charAt(i)) return false;
        return helper(s1, s2, i-1);
    }
}