import java.util.*;
public class HouseRobber{
    public static int rob(int[] nums) {
        return helper(nums, nums.length - 1);
    }
    private static int helper(int[] nums, int index) {
        // Base case: No houses left to rob
        if (index < 0) return 0;

        // Recursive case: Rob the current house or skip it
        int robCurrent = nums[index] + helper(nums, index - 2);
        int skipCurrent = helper(nums, index - 1);

        // Return the maximum money we can rob
        return Math.max(robCurrent, skipCurrent);
    }
    public static void main(String[] args){
        int[] arr = {10,20,30,10};
        System.out.println(rob(arr));
    }
}