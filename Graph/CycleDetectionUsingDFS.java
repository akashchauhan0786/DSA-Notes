class Solution {
    public boolean dfs(int node, int parent, boolean vis[], ArrayList < ArrayList < Integer >> adj) {
        vis[node] = true;
        for (Integer it: adj.get(node)) {
            if (vis[it] == false) {
                if (dfs(it, node, vis, adj))
                    return true;
            } else if (it != parent)
                return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }
}
