import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<Character>> mpp = new HashMap<>();
        mpp.put('2', Arrays.asList('a', 'b', 'c'));
        mpp.put('3', Arrays.asList('d', 'e', 'f'));
        mpp.put('4', Arrays.asList('g', 'h', 'i'));
        mpp.put('5', Arrays.asList('j', 'k', 'l'));
        mpp.put('6', Arrays.asList('m', 'n', 'o'));
        mpp.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mpp.put('8', Arrays.asList('t', 'u', 'v'));
        mpp.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0, mpp);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index, Map<Character, List<Character>> mpp) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        List<Character> letters = mpp.get(digit);
        for (char letter : letters) {
            current.append(letter);
            backtrack(result, current, digits, index + 1, mpp);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
    }
}