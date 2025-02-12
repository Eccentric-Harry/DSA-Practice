public class StocksI{
    public static int maxProfit(int[] arr) {
        int profit = 0;
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            int currProfit = arr[i] - min;
            profit = Math.max(currProfit,profit);
            min = Math.min(min,arr[i]);
        }
        return profit;
    }
}