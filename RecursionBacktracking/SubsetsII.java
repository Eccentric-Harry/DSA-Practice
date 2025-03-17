import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> tempList, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        tempList.add(nums[index]);
        backtrack(nums, index + 1, tempList, res);
        tempList.remove(tempList.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        
        backtrack(nums, index + 1, tempList, res);
    }
}