import java.util.*;
public class Subsets{
    public static void main(String[] args){
        int[] arr = {1,2,4,5};
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, arr.length-1, ans, new ArrayList<>());
        System.out.println(ans);
    }
    private static void helper(int[] arr, int index, List<List<Integer>> ans, List<Integer> li){
        if(index < 0){
            ans.add(new ArrayList<>(li));
            return;
        }
        li.add(arr[index]);
        helper(arr, index-1, ans, li);
        li.remove(li.size()-1);
        helper(arr, index-1, ans, li);
    }
}