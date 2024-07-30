import java.util.Arrays;

public class Solution {
    public static int maxDifference(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        int n = arr.length;
        int sumA = 0;
        int sumB = 0;

        // Allocate elements to maximize the difference
        for (int i = 0; i < n / 2; i++) {
            sumA += arr[n - 1 - i];
            sumB += arr[i];
        }

        // If there's an odd number of elements, add the middle element to sumA
        if (n % 2 != 0) {
            sumA += arr[n / 2];
        }

        // Calculate the difference
        int maxDiff = Math.abs(sumA - sumB);

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, -1, 4};
        System.out.println("Maximum Difference = " + maxDifference(arr));  // Output: Maximum Difference = 18
    }
}
