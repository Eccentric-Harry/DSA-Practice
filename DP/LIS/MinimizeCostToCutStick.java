public class MinimizeCostToCutStick{
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        for(int i = 1; i < arr.length-1; i++){
            arr[i] = cuts[i-1];
        }
        Arrays.sort(arr);
        return helper(1,arr.length-1,arr);
    }
    int helper(int i, int j, int[] arr){
        if(i > j) return 0;
        int min = Integer.MAX_VALUE;
        for(int ind = 0; ind < arr.length; ind++){
            int cost = arr[j+1] - arr[i-1] + helper(i,ind-1) + helper(ind+1, j);
            min  = Math.min(cost, min);
        }
        return min;
    }
}