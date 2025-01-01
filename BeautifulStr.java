import java.util.*;
public class BeautifulStr {
    // public int minChanges(String s) {
        
    // }
    public static List<String> helper(String s){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            String str = new String();
            for(int j = 0; j < i+1; j++){
                str+=s.charAt(j);
            }
            list.add(str);
        }
        return list;
    }
    public static void main(String[] args){
        String s = "1010";
        System.out.println(helper(s));
    }
}