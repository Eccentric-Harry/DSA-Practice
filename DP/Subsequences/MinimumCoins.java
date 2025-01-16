import java.util.*;
public class MinimumCoins{
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, coins.length-1);
    }
    public static int helper(int[] coins, int target, int index){
        if(index == 0){
            if(target%coins[index] == 0){
                return target/coins[index];
            }else{
                return 0;
            }
        }
        int notTake = 0 + helper(coins, target, index-1);
        int take = Integer.MAX+VALUE;
        if(target >= coins[index]){
            take = 1 + helper(coins, target-coins[index], index);
        }
        return Math.min(take, notTake);
    }
}