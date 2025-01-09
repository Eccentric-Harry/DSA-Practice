import java.util.*;
public class HouseRobber{
    public static int rob(int[] nums) {
        return helper(nums, 0);
    }
    public static int helper(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }
        int pickCurrent = nums[index] + helper(nums, index+2);
        int skipCurrent = helper(nums, index+1);
        return Math.max(pickCurrent,skipCurrent);
    }
}