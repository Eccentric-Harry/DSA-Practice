/*
PROBLEM STATEMENT:
A trading company has N different stocks, each with a certain profit percentage. While trading, a frequent trader found out that as per new policies whenever a stock with a K profit percentage is bought, all the stocks with an exact K-1 profit percentage cannot be bought. Traders wished to know the maximum profit percentage that can be achieved by selecting optimal stocks. As a trading agent, help the trader to find the maximum profit percentage that can be achieved as per the new policies.

Write an algorithm to find the maximum profit percentage that can be achieved by selecting stocks as per the new policies.

Input:
- The first line of input consists of an integer-stock size, representing the number of stocks the trading company has (N).
- The next line consists of N space-separated integers representing the profit percentage for each stock.

Output:
- Print an integer representing the maximum profit percentage that can be achieved by selecting stocks as per the new policies.

Example:

Input:
6
1 0 8 1 2 9 7

Output:
20

Explanation:
Maximum profit percentage can be achieved by selecting stocks (2, 8, 10). When stocks with profit percentages 2, 8, and 10 are selected, stocks with profit percentages 1, 7, and 9 cannot be selected. So the maximum profit percentage that can be achieved is 20.
*/

import java.util.*;

public class StocksAdv {
    static List<Integer> sortedKs;
    static int[] sumKArray;
    static Integer[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] profits = new int[N];
        for (int i = 0; i < N; i++) {
            profits[i] = sc.nextInt();
        }

        Map<Integer, Integer> sumK = new HashMap<>();
        for (int num : profits) {
            sumK.put(num, sumK.getOrDefault(num, 0) + num);
        }

        sortedKs = new ArrayList<>(sumK.keySet());
        Collections.sort(sortedKs);
        int n = sortedKs.size();
        sumKArray = new int[n];
        for (int i = 0; i < n; i++) {
            sumKArray[i] = sumK.get(sortedKs.get(i));
        }

        memo = new Integer[n][2];
        int result = recurse(0, false);
        System.out.println(result);
    }

    private static int recurse(int index, boolean prevTaken) {
        if (index >= sortedKs.size()) {
            return 0;
        }

        int pt = prevTaken ? 1 : 0;
        if (memo[index][pt] != null) {
            return memo[index][pt];
        }

        int currentK = sortedKs.get(index);
        int currentSum = sumKArray[index];

        boolean canTake = false;
        if (index == 0) {
            canTake = true;
        } else {
            int prevK = sortedKs.get(index - 1);
            if (currentK - prevK != 1) {
                canTake = true;
            } else {
                canTake = !prevTaken;
            }
        }

        int take = 0;
        if (canTake) {
            take = currentSum + recurse(index + 1, true);
        }
        int notTake = recurse(index + 1, false);

        int max = Math.max(take, notTake);
        memo[index][pt] = max;
        return max;
    }
}



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline

        int[] profits = new int[N];
        for (int i = 0; i < N; i++) {
            profits[i] = sc.nextInt();
        }

        Map<Integer, Integer> sumK = new HashMap<>();
        for (int num : profits) {
            sumK.put(num, sumK.getOrDefault(num, 0) + num);
        }

        List<Integer> sortedKs = new ArrayList<>(sumK.keySet());
        Collections.sort(sortedKs);

        int prevTake = 0;
        int prevNotTake = 0;
        int prevK = -2; // Initialized to a value that can't be adjacent to the first K

        for (int k : sortedKs) {
            int currentSum = sumK.get(k);
            int newTake, newNotTake;

            if (k == prevK + 1) {
                newTake = currentSum + prevNotTake;
                newNotTake = Math.max(prevTake, prevNotTake);
            } else {
                int maxPrev = Math.max(prevTake, prevNotTake);
                newTake = currentSum + maxPrev;
                newNotTake = maxPrev;
            }

            prevTake = newTake;
            prevNotTake = newNotTake;
            prevK = k;
        }

        System.out.println(Math.max(prevTake, prevNotTake));
    }
}