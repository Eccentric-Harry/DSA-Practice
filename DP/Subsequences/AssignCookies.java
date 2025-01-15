import java.util.*;
public class AsssignCookies{
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        for(int i = 0; i < s.length; i++){
            if(j < g.length && s[i] >= g[j]) {
                count++;
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g,s));
    }
}