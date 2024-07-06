public class KadaneAlgo{
    public static int maxSumSubArr(int[] nums){
        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSumSubArr(nums));
    }
}
