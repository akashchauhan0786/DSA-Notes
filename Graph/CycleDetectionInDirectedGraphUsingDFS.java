class Solution {
    private boolean dfs(int v, boolean visited[], boolean stack[],
     ArrayList<ArrayList<Integer>> adj) {
         visited[v] = true;
         stack[v] = true;
         for(Integer it : adj.get(v)) {
             if(visited[it] == false) {
                 if(isCyclePresent(it, visited, stack, adj)) {
                     return true;
                 }
             } else if (stack[it] == true) {
                 return true;
             }
         }
         stack[v] = false;
         return false;
     }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code hereboolen
        boolean visited[] = new boolean[V];
        boolean stack[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                if(dfs(i, visited, stack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
