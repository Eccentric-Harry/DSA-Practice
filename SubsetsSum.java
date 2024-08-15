import java.util.*;
public class SubsetsSum{
    public static List<Integer> sumSubsets(int[] arr){
        List<List<Integer>> res = subsets(arr);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> list : res){
            int sum = 0;
            for(int i : list){
                sum+=i;
            }
            result.add(sum);
        }
        return result;
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int totalSubsets = (int) Math.pow(2, nums.length);
        for(int i = 0; i < totalSubsets; i++){
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if((i & (1 << j))!=0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    public static void main(String[] args){
        SubsetsSum ss = new SubsetsSum();
        int[] arr = {1,2,3};
        System.out.println(ss.sumSubsets(arr));
    }
}