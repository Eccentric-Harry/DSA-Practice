import java.util.*;
public class NGEStack{
    public int[] nge(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        nge[arr.length-1] = -1;
        stack.push(arr[arr.length-1]);
        for(int i = arr.length-2; i >=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
            }
            if(!stack.isEmpty()){
                nge[i] = stack.peek();
            }else{
                nge[i] = -1;
            }
            
            stack.push(arr[i]);
        }
        return nge;
    }
    public static void main(String[] args){
        int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6};
        NGEStack obj = new NGEStack();
        int[] ans= obj.nge(arr);

        System.out.println(Arrays.toString(ans));
    }
}