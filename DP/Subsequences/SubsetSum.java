// when we refer to a subsequence or a subset, the only thing that we need to rember is that the elements in it should folllow the order of it's parent set.
import java.util.*;
public class SubsetSum{
    static Boolean isSubsetSum(int arr[], int target) {
        return helper(arr,arr.length-1,target);
    }
    private static boolean helper(int[] arr, int index, int target){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return target == arr[0];
        }
        boolean not_Take = helper(arr, index-1,target);
        boolean take = false;
        if(target>=arr[index]){
            take = helper(arr, index-1, target - arr[index]);
        }
        return take || not_Take;
    }
    
    public static void main(String[] args){
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr,4));
    }
} 