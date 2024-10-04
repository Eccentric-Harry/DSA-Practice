public class Pattern {
    public static void main(String[] args) {
        int n = 5; // The maximum width of the diamond pattern
        
        // Upper part of the diamond
        for (int i = 1; i <= n; i += 2) {
            for (int j = n; j > i; j -= 2) {
                System.out.print(" "); // Print leading spaces
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line
        }

        // Lower part of the diamond
        for (int i = n - 2; i >= 1; i -= 2) {
            for (int j = n; j > i; j -= 2) {
                System.out.print(" "); // Print leading spaces
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*"); // Print stars
            }
            System.out.println(); // Move to the next line
        }
    }
}
