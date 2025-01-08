// this is similar to the previous prooblem but the only constraint is that we need to stop the further execution once we recieve one answer. so how do we do taht? 
// also, in this example, we jave used a sum requirement to meet the constraint and stop the further execution of the recursive calls. 

import java.util.*;
public class PickNotPickII{
    private static void fun(int index, int[] arr, int target){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,arr, new ArrayList<>(), ans, n, target,0);
        System.out.println(ans);
    }
    public static boolean helper(int index, int[] arr, List<Integer> li, List<List<Integer>> ans, int n,int target, int currSum){
        if(index >= n){
            if(currSum == target){
                ans.add(new ArrayList<>(li));
                return true;
            }
            return false;
        }
        // pick the element;
        li.add(arr[index]);
        currSum+=arr[index];
        if(helper(index+1, arr, li, ans, n,target, currSum) == true) return true;
        // remove the element for other possible outcome (unpick);
        li.remove(li.size()-1);
        currSum-=arr[index];
        if(helper(index+1, arr,li,ans, n, target, currSum) == true) return true;
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1,2,1};
        fun(0,arr,2);
    }
}