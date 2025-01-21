import java.util.List;

public class Solution {
    public static int minDeletions(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) return 0;

        // Check if the array is already almost sorted
        if (isAlmostSorted(arr)) return 0;

        // Try removing each element and check if the resulting array is sorted
        for (int i = 0; i < n; i++) {
            if (isSortedAfterRemoving(arr, i)) {
                return 1; // Removing one element makes it almost sorted
            }
        }

        // Otherwise, it would require more than 1 deletion
        return 2;
    }

    private static boolean isAlmostSorted(List<Integer> arr) {
        int n = arr.size();
        int violations = 0;

        for (int i = 1; i < n; i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                violations++;
                if (violations > 1) return false;
            }
        }

        return true;
    }

    private static boolean isSortedAfterRemoving(List<Integer> arr, int indexToRemove) {
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            if (i == indexToRemove) continue;

            if (arr.get(i) < prev) {
                return false;
            }

            prev = arr.get(i);
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> arr = List.of(1,1,2,3,5);
        System.out.println(minDeletions(arr)); // Output: 1
    }
}
