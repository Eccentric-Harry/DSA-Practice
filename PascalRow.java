import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(pascalRow(i));
        }
        return ans;
    }

    public List<Integer> pascalRow(int row) {
        List<Integer> pascal = new ArrayList<>();
        int ans = 1;
        pascal.add(ans);
        for (int i = 1; i <= row; i++) {
            ans = ans * (row - i + 1) / i;
            pascal.add(ans);
        }
        return pascal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println(result);
    }
}
