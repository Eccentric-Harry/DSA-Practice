import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class NinjaTraining{
    public static int maximumPoints(int arr[][], int N) {
        return helper(arr,arr.length-1,arr.length);
    }
    public static int helper(int[][] arr, int day, int last){
        if(day==0){
            int maxi = 0;
            for(int i = 0; i <=2; i++){
                if(i!=last){
                    maxi = Math.max(maxi, arr[day][i]);
                }
            }
            return maxi;
        }
        int max = 0;
        for(int i = 0; i <=2; i++){
            if(i!=last){
                int points = arr[day][i] + helper(arr,day-1,i);
                max = Math.max(points,max);
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[][] arr = {
            {3, 6, 8}, {2, 8, 5}, {9, 7, 2}, {5, 9, 4}, {1, 4, 3}, 
            {7, 2, 6}, {8, 3, 5}, {4, 6, 7}, {2, 1, 9}, {6, 5, 8},
            {3, 8, 4}, {7, 6, 2}, {5, 9, 7}, {2, 4, 6}, {8, 5, 3}
        };

        int N = arr.length;

        // Log start time
        long startTime = System.nanoTime();

        // Perform the operation
        System.out.println("Maximum Points: " + maximumPoints(arr, N));

        // Log end time
        long endTime = System.nanoTime();

        // Calculate and print elapsed time in milliseconds
        System.out.println("Time Taken: " + (endTime - startTime) / 1_000_000.0 + " ms");

    }
}