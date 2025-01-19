import java.util.*;
public class TargetSumMemo{
    public static int findTargetSumWays(int[] nums, int target){
        HashMap<String, Integer> mpp = new HashMap<>();
        return helper(nums, target, nums.length-1, mpp);
    }
    public static int helper(int[] nums, int target, int index, HashMap<String, Integer> mpp){
        if(index < 0){
            return (target == 0) ? 1 : 0;
        }
        String key = index + "," + target;
        if(mpp.containsKey(key)){
            return mpp.get(key);
        }
        int add = helper(nums,target-nums[index], index-1, mpp);
        int sub = helper(nums, target+nums[index], index-1, mpp);
        mpp.put(key, add+sub);
        return mpp.get(key);
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }
}