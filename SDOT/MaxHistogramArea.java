import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = nextSmaller(heights);
        int[] pse = prevSmaller(heights);
        int maxArea = 0;
        
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    
    public int[] nextSmaller(int[] heights){
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            
            nse[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        
        return nse;
    }
    
    public int[] prevSmaller(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return pse;
    }
}