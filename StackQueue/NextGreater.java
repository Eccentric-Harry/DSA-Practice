import java.util.*;
public class NextGreater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length];
        boolean exist = false;
        arr[nums2.length-1] = -1;
        for(int i = 0; i < nums2.length-1; i++){
            for(int j = i+1; j<nums2.length; j++){
                exist = false;
                if(nums2[j] > nums2[i]){
                    arr[i] = nums2[j];
                    exist = true;
                    break;  
                }
            }
            if(!exist){
                arr[i] = -1;
            }
        }
        
        int[] newArr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int j = getIndex(nums2, nums1[i]);
            newArr[i] = arr[j];
        }
        return newArr;
    }
    public int getIndex(int[] nums2, int x){
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] == x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        NextGreater ng = new NextGreater();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = ng.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}