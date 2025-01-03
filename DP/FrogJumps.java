import java.util.Arrays;
public class FrogJumps{
    public static int minimumEnergy(int[] arr, int N){
        return helper(arr, N-1);
    }
    public static int helper(int[] arr, int steps){
        if(steps == 0){
            return 0;
        }
        int oneStep = helper(arr, steps-1) + Math.abs(arr[steps] - arr[steps-1]);
        int twoStep = Integer.MAX_VALUE;
        if(steps > 1){
            twoStep =helper(arr, steps-2) + Math.abs(arr[steps] - arr[steps-2]);
        }
        return Math.min(oneStep, twoStep);
    }
    public static void main(String[] args){
        int[] arr = {30,10,60,10,60,50};
        System.out.println(minEnergy(arr,6));
    }
    // using DP
    public static int minEnergy(int[] arr, int N){
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        return help(arr, N-1, dp);
    }
    public static int help(int[] arr, int steps, int[] dp){
        if(steps == 0){
            return 0;
        }
        if(steps == 1){
            return Math.abs(arr[1] - arr[0]);
        }
        if(dp[steps]!= 1){
            return dp[steps];
        }
        return Math.min(help(arr,steps-2,dp) + Math.abs(arr[steps] - arr[steps-2]), help(arr,steps-1, dp) + Math.abs(arr[steps] - arr[steps-1]));
    }
}
