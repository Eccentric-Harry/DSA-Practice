import java.util.*;
public class KMPAlgo{
    private static int[] buildLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static int strStr(String haystack, String needle) {
        // build lps[]
        int[] lps = buildLps(needle);
        // search using lps
        int i = 0, j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == needle.length()){
                return i - j;
            }else if(i < haystack.length() && haystack.charAt(i)!=needle.charAt(j)){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String text = "ABABCABCABABABD";
        String pattern ="ABABAB";
        System.out.println((strStr(text,pattern)));
    }
}