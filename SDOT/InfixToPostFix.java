import java.util.*;

class Solution {
    public static String infixToPostfix(String s) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
        precedence.put('(', 0);
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else if (precedence.containsKey(c)) {
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.get(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }
        return result.toString();
    }
}