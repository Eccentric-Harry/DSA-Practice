import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
public class NinjaTrainig{
    public static int maximumPoints(int[][] arr){
        int[][] dp = new int[arr.length][51];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,arr.length-1, arr.length,dp);
    }
    public static int helper(int[][] arr, int day, int last, int[][] dp){
        if(day == 0){
            int max = 0;
            for(int i = 0; i <=2; i++){
                max = Math.max(arr[day][i] , max);
            }
            return max;
        }
        if(dp[day][last] != -1){
            return dp[day][last];
        }
        int max = 0;
        for(int i = 0; i <=2; i++){
            int points = arr[day][i]+ helper(arr, day-1, i,dp);
            max = Math.max(max,points);
        }
        dp[day][last] = max;
        return max;
    }
    public static void main(String[] args){
       int[][] arr = {
    {3, 6, 8}, {2, 8, 5}, {9, 7, 2}, {5, 9, 4}, {1, 4, 3}, 
    {7, 2, 6}, {8, 3, 5}, {4, 6, 7}, {2, 1, 9}, {6, 5, 8},
    {3, 8, 4}, {7, 6, 2}, {5, 9, 7}, {2, 4, 6}, {8, 5, 3},
    {4, 3, 7}, {6, 8, 2}, {9, 7, 5}, {5, 4, 6}, {3, 2, 8},
    {1, 6, 7}, {7, 9, 3}, {2, 5, 4}, {8, 4, 6}, {9, 7, 5},
    {3, 8, 6}, {6, 2, 9}, {5, 4, 7}, {7, 6, 3}, {8, 5, 4},
    {4, 3, 9}, {2, 8, 5}, {6, 7, 4}, {9, 3, 6}, {7, 5, 8},
    {1, 4, 6}, {8, 3, 7}, {5, 6, 4}, {3, 2, 9}, {4, 9, 7},
    {2, 6, 3}, {6, 8, 5}, {7, 3, 4}, {8, 5, 2}, {9, 4, 6},
    {3, 7, 8}, {5, 9, 6}, {7, 6, 3}, {4, 5, 8}, {2, 7, 9}
};

         LocalDateTime now = LocalDateTime.now();
        
        // Define a formatter for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format and print the current date and time
        String formattedDateTime = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        System.out.println(maximumPoints(arr));
         LocalDateTime now1 = LocalDateTime.now();
        
        // Define a formatter for displaying the date and time
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format and print the current date and time
        String formattedDateTime1 = now1.format(formatter1);
        System.out.println("Current Date and Time: " + formattedDateTime1);
    }
    
}
