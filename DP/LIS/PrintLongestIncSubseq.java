import java.util.Arrays;
import java.util.ArrayList;
public class PrintLongestIncSubseq{
    public static void longestIncreasingSubsequence(int n, int arr[]) {
        ArrayList<Integer> li = new ArrayList<>();
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int[] hash = new int[arr.length];
        int maxIndex = -1;
        int max = 1;
        for(int i = 0; i < arr.length; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }
        for(int i = 0 ; i < dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        while(hash[maxIndex]!=maxIndex){
            li.add(arr[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));
    }
    public static void main(String[] args){
        int[] nums = {5,4,11,1,16,8};
        longestIncreasingSubsequence(nums.length, nums);
    }
}