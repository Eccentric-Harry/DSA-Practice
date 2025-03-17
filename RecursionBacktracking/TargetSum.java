import java.util.*;
public class TargetSum{
    public static void main(String[] args){
        int[] arr = {1,4,64,9,5,3};
        int target = 14;
        boolean res = helper(arr, target, arr.length-1);
        System.out.println(res);
    }
    private static boolean helper(int[] arr, int target, int index){
        if(target == 0) return true;
        if(index < 0) return false;
        boolean take = false;
        if(target >= arr[index]){
            take = helper(arr, target-arr[index], index-1);
        }
        boolean notTake = helper(arr, target, index-1);
        return take || notTake;
    }
}