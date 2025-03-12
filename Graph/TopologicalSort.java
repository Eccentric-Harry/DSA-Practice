public class TopologicalSort{
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        int[] inDegree = new int[n];
        Arrays.fill(inDegree,0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                stack.push(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            int node = stack.pop();
            result.add(node);
            for(Integer it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    stack.push(it);
                }
            }
        }
        return result;
    }
}