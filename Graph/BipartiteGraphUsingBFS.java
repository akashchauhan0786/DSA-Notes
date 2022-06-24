class Solution
{   
    private boolean bfs(int v, int color[], ArrayList<ArrayList<Integer>>adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        color[v] = 1;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            for(Integer it : adj.get(node)) {
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    queue.add(it);
                } else if(color[it] == color[node]) {
                    return false;
                }
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
                if(!bfs(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
