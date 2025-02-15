import java.util.ArrayList;
import java.util.Collections;

public class LISBS {
    public static int longestIncreasingSubsequence(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);
                if (ind < 0) {
                    ind = -(ind + 1); // Convert the negative result to an insertion point
                }
                temp.set(ind, arr[i]);
            }
        }
        
        return temp.size();
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        System.out.println("Length of Longest Increasing Subsequence: " + longestIncreasingSubsequence(arr, n));
    }
}
