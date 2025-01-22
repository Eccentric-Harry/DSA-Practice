import java.util.List;

public class MountainArrayFix {

    private static boolean isIncreasing(List<Integer> arr, int end) {
        for (int j = 1; j <= end; j++) {
            if (arr.get(j) <= arr.get(j - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecreasing(List<Integer> arr, int start) {
        for (int j = start + 1; j < arr.size(); j++) {
            if (arr.get(j) >= arr.get(j - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int minDeletions(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) return 0;

        // Find the highest peak (last increasing element before a decrease)
        int peak = -1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                peak = i - 1;
                break;
            }
        }

        // If no peak is found, the array is already strictly increasing
        if (peak == -1) return 0;

        // Check if removing one of the elements around the peak can form a mountain
        boolean canFormMountain = false;

        // Try removing the peak element
        if (peak > 0  && isIncreasing(arr, peak - 1) && isDecreasing(arr, peak + 1)) {
            canFormMountain = true;
        }

        // Try removing the element after the peak
        if (peak + 1 < n && isIncreasing(arr, peak) && isDecreasing(arr, peak + 2)) {
            canFormMountain = true;
        }

        // Try removing both the peak and the element after
        if (peak > 0 && peak + 1 < n && isIncreasing(arr, peak - 1) && isDecreasing(arr, peak + 2)) {
            canFormMountain = true;
        }

        // If we can form a valid mountain by removing one element
        if (canFormMountain) return 1;

        // If none of the above conditions hold, remove two elements
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions(List.of(1, 3, 2, 4, 3))); // Expected: 1
        System.out.println(minDeletions(List.of(1, 2, 3, 4, 5))); // Expected: 0
        System.out.println(minDeletions(List.of(5, 4, 3, 2, 1))); // Expected: 0
        System.out.println(minDeletions(List.of(1, 2, 3, 1, 2, 3))); // Expected: 2
        System.out.println(minDeletions(List.of(1, 2, 1, 2, 1))); // Expected: 2
    }
}
