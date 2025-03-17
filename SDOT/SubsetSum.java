class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr, arr.length-1, result, 0);
        return result;
    }
    private void helper(int[] nums, int index, ArrayList<Integer> result, int currSum){
        if(index < 0){
            result.add(currSum);
            return;
        }
        helper(nums, index-1, result, currSum + nums[index]);
        helper(nums, index-1, result, currSum);
    }
}