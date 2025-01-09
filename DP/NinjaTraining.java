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
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}};
         LocalDateTime now = LocalDateTime.now();
        
        // Define a formatter for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format and print the current date and time
        String formattedDateTime = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        System.out.println(maximumPoints(arr,3));
         LocalDateTime now = LocalDateTime.now();
        
        // Define a formatter for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format and print the current date and time
        String formattedDateTime = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
    }
}