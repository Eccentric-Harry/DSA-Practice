import java.util.*;

public class AlienDictionary {
    static ArrayList<ArrayList<Character>> graph;
    static int[] inDegree;

    public static void main(String[] args) {
        graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        findOrder(words);
        System.out.println(topoSort());
    }

    public static void findOrder(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    addEdge(first.charAt(j), second.charAt(j));
                    break;
                }
            }
        }
    }

    private static void addEdge(char a, char b) {
        graph.get(a - 'a').add(b);
    }

    private static List<Character> topoSort() {
        List<Character> res = new ArrayList<>();
        inDegree = new int[26];

        // Compute in-degrees
        for (int i = 0; i < 26; i++) {
            for (char ch : graph.get(i)) {
                inDegree[ch - 'a']++;
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0 && !graph.get(i).isEmpty()) {
                q.add((char) (i + 'a'));
            }
        }
        while (!q.isEmpty()) {
            char curr = q.poll();
            res.add(curr);

            for (char ch : graph.get(curr - 'a')) {
                inDegree[ch - 'a']--;
                if (inDegree[ch - 'a'] == 0) {
                    q.add(ch);
                }
            }
        }

        return res;
    }
}
