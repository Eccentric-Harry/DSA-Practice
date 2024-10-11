import java.util.*;
public class MaximalRectangle{
    public static int[][] prefixSum(char[][] matrix){
        int[][] ps = new int[matrix.length][matrix[0].length];
        for(int col = 0; col < matrix[0].length; col++){
            int row = 0;
            while(row < matrix.length){
                if(matrix[row][col]!='0'){
                    if(row > 0){
                        ps[row][col] = 1 + ps[row-1][col];
                    }else{
                        ps[row][col] = 1;
                    }
                }else{
                    ps[row][col] = 0;
                }
                row++;
            }
        }
        return ps;
    }
    public static int maximalRectangle(char[][] matrix) {
        int[][] ps = prefixSum(matrix);
        int max = 0;
        for(int[] row : ps){
            max = Math.max(max,largestRectangleArea(row));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nsi = nse(heights); 
        int[] psi = pse(heights); 
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int largest = (nsi[i] - psi[i] - 1) * heights[i]; 
            max = Math.max(largest, max);
        }
        
        return max;
    }

    public int[] nse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nsi = new int[arr.length];
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsi[i] = stack.isEmpty() ? arr.length : stack.peek();  
            stack.push(i);  
        }
        
        return nsi;
    }


    public int[] pse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] psi = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            psi[i] = stack.isEmpty() ? -1 : stack.peek(); 
            stack.push(i);  
        }
        
        return psi;
    }
    
}