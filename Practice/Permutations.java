import java.util.*;
public class Permutations{
    public static void main(String[] args){
        String s = "ABC";
        distinctPermutations(s);
    }
    public static void distinctPermutations(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        input = new String(chars);
        permute(input.toCharArray(), 0);
    }
    public static void permute(char[] chars, int index){
        if(index == chars.length-1){
            System.out.println(String.valueOf(chars));
            return;
        }
        Set<Character> unique = new HashSet<>();
        for(int i = index; i < chars.length; i++){
            if(unique.contains(chars[i])){
                continue;
            }
            unique.add(chars[i]);
            swap(chars,i,index);
            permute(chars,index+1);
            swap(chars,i,index);
        }
    }
    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}