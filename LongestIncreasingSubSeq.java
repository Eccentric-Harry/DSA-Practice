import java.util.Arrays;
public class LongestIncreasingSubSeq{
    public int lenghtOfLIS(int[] nums){
                if(nums==null){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]<min){
                min = nums[i];
                minIndex = i;
            } 
        }   
        int count = 0;
        for(int i = minIndex+1; i < nums.length; i++){
            int j = i;
            while(j < nums.length){
                int[] subArray = Arrays.copyOfRange(nums, i, nums.length);
                if(nums[j]> min && doesNotHaveMin(subArray, nums[j])){
                    count++;
                    min = nums[j];
                    j++;
                }
            }
        }
        return count;
    }

    public boolean doesNotHaveMin(int[] arr, int min){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]<min){
                return false;
                
            }
        }
        return true;
    }

    public static void main(String[] args){
        LongestIncreasingSubSeq lis = new LongestIncreasingSubSeq();
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lis.lenghtOfLIS(arr));
    }
}