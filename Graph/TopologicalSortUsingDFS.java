class Solution
{   
    private static void dfs(int v, Stack<Integer> stack, boolean visited[],
    ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for(Integer it : adj.get(v)) {
            if(visited[it] == false) {
                 dfs(it, stack, visited, adj);
            }
        }
        stack.push(v);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int result[] = new int[V];
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i = 0 ; i <V; i++) {
            if(visited[i] == false) {
                dfs(i, stack, visited, adj);
            }
         }
         int in = 0;
        while(!stack.isEmpty()) {
            result[in++] = stack.pop();
        }
        return result;
    }
}
