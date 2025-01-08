// in this variation, we are just trying to print  the number of the possible outcomes (in our case the number of all the subsequences that sum isequal to the target. and then return the count. that's it.)

import java.util.*;
public class PickNotPickII{
    private static void fun(int index, int[] arr, int target){
        int n = arr.length;
        int count = helper(0,arr, new ArrayList<>(),n, target,0);
        System.out.println(count);
    }
    public static int helper(int index, int[] arr, List<Integer> li, int n,int target, int currSum){
        if(index >= n){
            if(currSum == target){
                return 1;
            }
            return 0;
        }
        // pick the element;
        li.add(arr[index]);
        currSum+=arr[index];
        int l = helper(index+1, arr, li, n,target, currSum);
        // remove the element for other possible outcome (unpick);
        li.remove(li.size()-1);
        currSum-=arr[index];
        int r = helper(index+1, arr,li, n, target, currSum);
        return l+r;
    }
    public static void main(String[] args){
        int[] arr = {1,2,1};
        fun(0,arr,2);
    }
}