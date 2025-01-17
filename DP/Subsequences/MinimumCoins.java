import java.util.*;
public class MinimumCoins{
     public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount, coins.length - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static int helper(int[] coins, int target, int index){
        if(index == 0){
            if(target%coins[index] == 0){
                return target/coins[index];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int notTake = helper(coins, target, index-1);
        int take = Integer.MAX_VALUE;
        if (target >= coins[index]) {
            int subResult = helper(coins, target - coins[index], index);
            if (subResult != Integer.MAX_VALUE) { // Avoid overflow
                take = 1 + subResult;
            }
        }

        return Math.min(take, notTake);
    }
}