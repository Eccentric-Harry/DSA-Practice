import java.util.*;
public class HousrRobber2{
public int rob(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            arr1[i - 1] = nums[i];
        }

        // Exclude the last element (nums[nums.length - 1])
        int[] arr2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            arr2[i] = nums[i];
        }
        return Math.max(helper(arr1), helper(arr2));
    }
    public static int helper(int[] nums){
        if(nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int prev1 = 0;
        int prev2 = 0;

        for(int num: nums){
            int temp = prev1;
            prev1 = Math.max(num+prev2, prev1);
            prev2 = temp;
        } 
        return prev1;
    }
}