class Solution {
    public int maxProfit(int[] prices) {
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        int n = prices.length;
        for(int i = n-1; i >=0; i--){
            for(int b = 0; b<=1; b++){
                for(int cap = 1; cap<=2; cap++){
                    if(b==1){
                        curr[b][cap] =  Math.max((-prices[i] + after[0][cap]), 0 + after[1][cap]);
                    }else{
                        curr[b][cap] = Math.max((prices[i]+after[1][cap-1]), (0 + after[0][cap]));
                    }
                }
            }
            after = curr;
        } 
        return after[1][2];
    }
}