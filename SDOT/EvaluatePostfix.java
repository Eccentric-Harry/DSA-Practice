import java.util.Stack;

class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            String token = arr[i];
            
            // Try to parse as a number
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } 
            // If it's not a number, it must be an operator
            catch (NumberFormatException e) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                
                int second = stack.pop();
                int first = stack.pop();
                
                if(token.equals("*")){
                    stack.push(first * second);
                } else if(token.equals("+")){
                    stack.push(first + second);
                } else if(token.equals("-")){
                    stack.push(first - second);
                } else if(token.equals("/")){
                    if (second == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    stack.push(first / second);
                } else {
                    throw new IllegalArgumentException("Unknown operator: " + token);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        
        return stack.pop();
    }
}