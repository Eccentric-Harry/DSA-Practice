class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        ArrayList<Integer> list = new ArrayList<>();
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                inDegree[adj.get(i).get(j)]++
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n ; i++){
            if(inDegree[i] == 0){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int node  = stack.pop();
            list.add(node);
            for(int neighbour : adj.get(node)){
                inDegree[neighbour]-=1;
                if(inDegree[neighbour] == 0){
                    stack.push(neighbour);
                }
            }
        }
        return list;
    }
    
}