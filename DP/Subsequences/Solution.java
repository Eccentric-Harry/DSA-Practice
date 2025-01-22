import java.io.*;
import java.util.*;

class Result {
    /*
     * Complete the 'drawingEdge' function below.
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int drawingEdge(int n) {
        final int MOD = 1000000007;
        
        // Calculate number of possible edges: nC2 = n*(n-1)/2
        // Need to handle potential overflow
        long numPairs;
        if (n % 2 == 0) {
            numPairs = (long)n/2 * (n-1);
        } else {
            numPairs = (long)(n-1)/2 * n;
        }
        
        // For n > 44721, numPairs will be > 10^9
        // In this case, due to the properties of modular arithmetic,
        // the result will be 0 as 2^(large number) mod (10^9 + 7) = 0
        if (n > 44721) {
            return 0;
        }
        
        // Calculate 2^numPairs modulo MOD using fast modular exponentiation
        long result = 1;
        long base = 2;
        
        while (numPairs > 0) {
            if (numPairs % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            numPairs /= 2;
        }
        
        return (int)result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.drawingEdge(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}