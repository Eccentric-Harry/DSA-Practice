import java.util.*;
public class Vowels{
    public static void main(String[] args){
        String s = "EccentricHarry";
        Set<Character> v = new HashSet<>();
        // v.add('a', 'e', 'i', 'o', 'u');
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');
        helper(s, s.length()-1, v);
    }
    private static void helper(String s, int index, Set<Character> v){
        if(index < 0) return;
        if(v.contains(Character.toLowerCase(s.charAt(index)))) System.out.println(s.charAt(index) + " ");
        helper(s, index-1, v);
    }
}