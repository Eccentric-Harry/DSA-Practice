import java.util.*;
public class MajorityElement{
    public int majorityElement(int[] nums){
        int count = 0;
        int res = 0;
        int ans = 0;
        Arrays.sort(nums);
        int mid = nums.length/2;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                count++;
                res = Math.max(res, count);
                if(res>mid){
                    ans = nums[i];
                    break;
                }
                continue;
            }else{
                ans = nums[i-1];
                count = 0;
            }
            ans = nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {3,2,3};
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(nums));
    }
} 