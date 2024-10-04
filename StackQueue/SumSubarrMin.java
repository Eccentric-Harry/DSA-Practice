import java.util.Stack;
public class SumSubarrMin{
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int m = nse[i]*pse[i];
            sum+=arr[i]*m;
        }
        return sum;
        
    }
    public int[] nse(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[arr.length];
        for(int i = arr.length; i >-0; i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            nse[i] = (!stack.isEmpty())? stack.peek(): -1;
            stack.push(arr[i]);
        }
        return nes;
    }
    public int[] pse(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            pse[i] = (!stack.isEmpty())? stack.peek(): -1;
            stack.push(arr[i]);
        }
        return pse;
    }
}