import java.util.*;
public class Knapstack{
    public  static int knapSack(int capacity, int val[], int wt[]) {
        return helper(capacity, val, wt, val.length-1);
    }
    public static int helper(int capacity, int[] val, int[] wt, int index){
        if(index ==0){
            if(wt[index] <= capacity){
                return val[index];
            }else{
                return 0;
            }
        }
        int notPick = 0 + helper(capacity,val,wt,index-1);
        int pick = 0;
        if(capacity >= wt[index]){
            pick = val[index]+helper(capacity-wt[index],val,wt,index-1);
        }
        return Math.max(pick,notPick);
    }
    public static void main(String[] args){
        int capacity = 4; int val[] = {1, 2, 3}, wt[] = {4, 5, 1};
        System.out.println(knapSack(capacity,val,wt));
    }
}