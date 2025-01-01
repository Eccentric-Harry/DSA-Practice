import java.util.*;
public class Permutations {
    public static void main(String[] args) {
        String input = "BAC";
        distinctPermutations(input);
    }

    public static void distinctPermutations(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars); 
        input = new String(chars);
        permute(input.toCharArray(), 0);
    }

    public static void permute(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(String.valueOf(chars)); // Print the permutation
            return;
        }

        Set<Character> used = new HashSet<>(); // To track used characters at the current index
        for (int i = index; i < chars.length; i++) {
            if (used.contains(chars[i])) {
                continue; // Skip duplicates
            }

            used.add(chars[i]);
            swap(chars, index, i); // Swap current index with i
            permute(chars, index + 1); // Recursively permute for the next index
            swap(chars, index, i); // Backtrack (restore original state)
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
