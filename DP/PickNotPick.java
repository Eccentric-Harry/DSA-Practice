// program to understand recursive approach behind pick and not pick approach for all the possible subsequences.
import java.util.*;
public class PickNotPick{
    private static void fun(int index, int[] arr){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,arr, new ArrayList<>(), ans, n);
        System.out.println(ans);
    }
    public static void helper(int index, int[] arr, List<Integer> li, List<List<Integer>> ans, int n){
        if(index >= n){
            ans.add(new ArrayList<>(li));
            return;
        }
        // pick the element;
        li.add(arr[index]);
        helper(index+1, arr, li, ans, n);
        // remove the element for other possible outcome (unpick);
        li.remove(li.size()-1);
        helper(index+1, arr,li,ans, n);
    }
    public static void main(String[] args){
        int[] arr = {3,1,2,2};
        fun(0,arr);
    }
}