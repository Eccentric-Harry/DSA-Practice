import java.util.*;
public class DFS{
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> li = new ArrayList<>();
        int V = adj.size();
        int[] visited = new int[V+1];
        Arrays.fill(visited,0);
        dfs(0,visited, adj, li);
        return li;
    }
    public static void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> li){
        visited[node] = 1;
        li.add(node);
        for(Integer it: adj.get(node)){
            if(visited[it]!=1){
                dfs(it,visited,adj,li);
            }
        }
    }
}