import java.util.*;
public class PrintList{
    public static void main(String[] args){
        List<Integer> li = Arrays.asList(12,434,647,768,972,13);
        helper(li.size()-1,li);
    }
    private static void helper(int index, List<Integer> li){
        if(index< 0) return;
        System.out.print(li.get(index) + " ");
        helper(index - 1, li);
    }
}