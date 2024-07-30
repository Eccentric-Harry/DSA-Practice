import java.util.Arrays;
public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 0;
        int count = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                count++;
            }else{
                count = 0;
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount+1;
    }

    public static void main(String args[]) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int ans = longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is: " + ans);
    }
}