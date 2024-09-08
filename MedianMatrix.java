public class MedianMatrix{
        int median(int matrix[][], int R, int C) {
        // code here   
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < R; i++){
            low = Math.min(low, matrix[i][0]);
        }
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < R; i++){
            high = Math.max(high, matrix[i][2]);
        }
        
        while(low <=high){
            int mid = (low+high) >> 1;
            int x = func(matrix, mid);
            if(x <= mid){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int func(int[][] matrix, int mid){
        int c = 0;
        for(int i = 0; i < matrix.length; i++){
            c += upperBound(matrix[i], mid);
        }
        return c;
    }
}