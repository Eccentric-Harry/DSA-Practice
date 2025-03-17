import java.util.*;
public class MaxMin{
    public static void main(String[] args){
        int[] nums = {21,345,65,78,121,78,872,34};
        int max = nums[0];
        int min = nums[0];
        Result result = new Result(max, min);
        helper(nums, result, nums.length-1);
        System.out.println("MAX " + result.max );
        System.out.println("MIN " + result.min);
    }
    private static void helper(int[] nums, Result result, int index){
        if(index < 0) return;
        result.max = Math.max(result.max, nums[index]);
        result.min = Math.min(result.min, nums[index]);
        helper(nums, result, index-1);
    }
}
class Result{
    int max;
    int min;
    
    Result(int max, int min){
        this.max = max;
        this.min = min;
    }
}