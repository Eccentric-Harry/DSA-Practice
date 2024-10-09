import java.util.*;
public class SumSubarrMin{
    public int[] nsi(int[] arr){
        int[] nsi = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nsi[i] = (!stack.isEmpty()) ? stack.peek() : arr.length;
            stack.push(i);
        }
        return nsi;
    }
    public int[] psi(int[] arr){
        int[] psi = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
     
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            psi[i] = (!stack.isEmpty()) ? stack.peek() : -1;
            stack.push(i);
        }
        return psi;
    }
    public static void main(String[] args){
        SumSubarrMin sb = new SumSubarrMin();
        int[] arr = {1,4,6,7,3,7,8,1};
        int[] ans = sb.psi(arr);
        System.out.println(Arrays.toString(ans));
    } 
}