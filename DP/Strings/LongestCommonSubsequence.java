import java.uitl.*;
public class LongestCommonSubsequence{
    public static int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2,text1.length()-1, text2.length()-1);
    }
    public static int helper(String a, String b, int index1, int index2){
        if(index1 == 0 && index){

        }
        int m = 0;
        int nm = 0;
        boolean match = a.charAt(index1) == b.charAt(index2);
        if(match){
            int m = 1 + helper(a,b,index1-1, index2-1);
        }else{
            nm = Math.max(helper(a,b,index-1, index2), helper(a,b, index1, index2-1));
        }
        return Math.max(m, nm);
    }   
}