import java.util.*;

public class PerfectSumII {
     static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        

        if (ind == 0){
            if (target == 0 && arr[0]==0) return 2;
            if(target==0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = notTaken + taken;
    }

    static int perfectSum(int[] num, int k) {
        int n = num.length;
        int dp[][] = new int[n][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWaysUtil(n - 1, k, num, dp);
        // int ans = findWaysUtil(n - 1, k, num, dp);
        // int zeros = countZeros(num);
        // if(zeros!=0){
        //     ans =  ans* (int) Math.pow(2,zeros);
        // }
        // return ans;

    }
    public static int countZeros(int[] nums){
        int count = 0;
        for(int num: nums){
            if(num == 0){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(nums, target)); 
    }
}
