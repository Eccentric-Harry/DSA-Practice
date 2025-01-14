import java.util.*;
public class PerfectSum{
    public static int perfectSum(int[] nums, int target) {
        return helper(nums,nums.length-1, target);
    }
    public static int helper(int[] nums, int index, int target){
        if(target == 0){
            return 1;
        }
        if(index == 0){
            if(nums[index] == target){
                return 1;
            }else{
                return 0;
            }
        }
        int not_Take = helper(nums, index-1, target);
        int take = 0;
        if(target >= nums[index]){
            take = helper(nums,index-1, target-nums[index]);
        }
        return take+not_Take;
    }
    public static void main(String[] args){
        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(nums,target));
    }
}