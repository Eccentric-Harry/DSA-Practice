import java.util.*;

public class TrappingRainWater {
    public static int[] leftMax(int[] arr) {
        int[] lm = new int[arr.length];
        lm[0] = arr[0];  
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lm[i] = max;
            max = (max>arr[i])? max : arr[i];
        }
        return lm;
    }

    public static int[] rightMax(int[] arr) {
        int[] rm = new int[arr.length];
        int max = arr[arr.length-1];
        rm[arr.length - 1] = arr[arr.length - 1];  
        for (int i = arr.length - 2; i >= 0; i--) {
            rm[i] = max;
            max = (max>arr[i]) ? max: arr[i];
        }
        return rm;
    }

    public static int trap(int[] height) {
        if (height.length == 0) return 0; 
        int[] lm = leftMax(height);
        int[] rm = rightMax(height);
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.max(0, Math.min(lm[i], rm[i]) - height[i]); 
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Arrays.toString(leftMax(arr)));
        System.out.println(Arrays.toString(rightMax(arr)));
        System.out.println(trap(arr));
    }
}
