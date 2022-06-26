class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int topo[] = new int[V];
        int indegree[] = new int[V];
        //finding indegree
        for(int i = 0; i < V; i++) {
            for(Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i<V;i++) {
            //adding nodes to queue with indegree = 0
            if(indegree[i] == 0) {
                queue.add(i);
            }
        } 
        int ind = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            topo[ind++] = node;
            for(Integer it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
       return topo;
    // to detect cycle    
       // if(cnt == N) return false;
       // return true;
    }
}
