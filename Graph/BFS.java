import java.util.*;
public class BFS{
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Arrays.fill(visited,0);
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer it: adj.get(node)){
                if(visited[it] == 0){
                    visited[it] = 1;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}