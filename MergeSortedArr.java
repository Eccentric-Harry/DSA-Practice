import java.util.Arrays;
public class MergeSortedArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k++] = nums2[j++];
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArr msa = new MergeSortedArr();
        msa.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
