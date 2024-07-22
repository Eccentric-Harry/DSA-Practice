public class MooreVotingAlgo{
    public static int majorityElement(int[] nums){
        int candidate = nums[0];
        int count = 1; 
        int i = 1;
        while(i < nums.length){
            if(nums[i] == candidate){
                count++;
            }else {
                count--;
            }
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
            i++;
        }
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate){
                c++;
            }
        }
        if(c > nums.length/2){
            return candidate;
        }
        return -1;
    }
}