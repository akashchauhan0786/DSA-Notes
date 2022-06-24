class Solution
{   
    private boolean dfs(int v, int color[], ArrayList<ArrayList<Integer>>adj) {
        if(color[v] == -1) 
            color[v] = 1;
        for(Integer it : adj.get(v)) {
            if(color[it] == -1) {
                color[it] = 1 - color[v];
                if(!dfs(it, color, adj)) {
                    return false;
                }
            } else if(color[it] == color[v]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i< V; i++) {
            if(color[i] == -1) {
                if(!dfs(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
