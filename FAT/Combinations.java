import java.util.*;

public class Combinations{
    public static int fact(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n * fact(n - 1);
    }
    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(9);
        numbers.add(12);
        numbers.add(19);
        numbers.add(61);
        numbers.add(19);

        // Calculate the combination value
        int n = numbers.size(); // Size of the list
        int r = 2; // Number of selections
        int result = fact(n) / (fact(r) * fact(n - r));

        // Output the result
        System.out.println("The combination value for the numbers list is: " + result);
    }
}
