import java.util.*;
public class SubsetSumII{
    public static int[][] func(int[] arr,int target, int n){
        int[][] dp = new int[n][target+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1, -1);
        }
        helper(arr, target,n-1, dp);
        return dp;
    }
    public static boolean helper(int[] arr, int target, int index, int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == 0) return arr[index] == target;

        if(dp[index][target]!=-1){
            return dp[index][target] == 1;
        }
        boolean not_Take = helper(arr, target, index-1, dp);
        boolean take = false;
        if(target >= arr[index]){
            take = helper(arr, target-arr[index], index-1, dp);
        }

        dp[index][target] = (take || not_Take) ? 1 : 0;
        
        return dp[index][target] == 1;
    }
    public static void main(String[] args){
        int[] arr = {3, 34, 4, 12, 5, 2};
        int[][] dp =  func(arr, 9, arr.length);
        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}