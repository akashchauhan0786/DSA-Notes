# Graph Traversal
  * BFS
    - Logic
      - Create a visited array to track for nodes not visit twice
      - Run loop for 1->N for all nodes(Graph can have multiple components)
        - if current node not visited then
          - Create a queue and add that node into queue and mark as visited
          - while !queue.isEmpty()
            - queue.poll the node and print that node or add into result list
            - Travers to all adjacent to that node 
            - check if not visited then add into queue and mark as visited
            - Repeat this step untill queue not empty
    - [Code](BFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, queue data structure
    
  * DFS
    - Logic
      - Create a visited array to track for nodes not visit twice
      - Run loop for 1->N for all nodes(Graph can have multiple components)
        - if current node not visited then
          - call dfs(currentNode,visited, adj)
          - In DFS method
           - Print that node or add into result list and mark as visited
           - Travers to all adjacent to that node 
           - check if not visited then call dfs(adjacentNode,visited, adj)
    - [Code](DFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, Auxiliary space(stack call)

# Cycle Detection In Undirected Graph
  * Using BFS
    - Logic 
      - First Create Node class that will contains two fields(node and parent)
      - Modify the BFS call a bit
      - Means while iterating its adjacent nodes
      ```
      for (Integer it : adj[node]){
             if (!visited[it])
             {
                 visited[it] = true;
                 q.push({it, node});
             }
             else if (par != it)
                 return true;
      } 
      ```
    - [Code](CycleDetectionInUnDirectedGraphUsingBFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, queue data structure
  
  * Using DFS
    - Logic 
      - Modify the DFS call a bit
      - Means while iterating its adjacent nodes
      ```
      for (Integer it: adj.get(node)) {
           if (vis[it] == false) {
               if (dfs(it, node, vis, adj))
                   return true;
           } else if (it != parent)
               return true;
       }
      ```
    - [Code](CycleDetectionInUnDirectedGraphUsingDFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, Auxiliary space(stack call)

# Bipartite Graph
## Bipartite of graph possible if we can color the graph using two color
  * Using BFS
    - Logic
      - Instead of visited array create color array and fill with -1
      - Run loop for 1->N for all nodes(Graph can have multiple components)
        - if color of current node == -1
          - Call BFS 
          - In BFS 
          ```
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
          ```
    - [Code](BipartiteGraphUsingBFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, queue data structure
 
 * Using DFS
    - Logic 
      - Modify the DFS call a bit
      - In DFS call
      ```
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
      ```
    - [Code](BipartiteGraphUsingDFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, Auxiliary space(stack call)

# Cycle Detection In Directed Graph
  * Using DFS
    - Logic 
    - Instead of parent node we need to keep track of node travasel if its visted already by a other node travesal then we can say it cycle present
      - Modify the DFS call a bit
      - Means we need stackcall array of node once travesal completed marked as 0 
      ```
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
      ```
    - [Code](CycleDetectionInDirectedGraphUsingDFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array and stack
    - Auxiliary Space Complexity:  O(N) Recursion call of DFS


# Topological Sort Using DFS
## It is linear ordering of vertices in DAG(Direct Acyclic Graph)such that there is an edge u—-> v, u appears before v in the ordering. 
  * Logic 
    - Modify the DFS call a bit
    - Means we need stack once travesal completed push into stack
      ```
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
      ```
    - [Code](TopologicalSortUsingDFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array and stack
    - Auxiliary Space Complexity:  O(N) Recursion call of DFS

# Topological Sort Using BFS(Kahn's Algorithm)
## It is linear ordering of vertices in DAG(Direct Acyclic Graph)such that there is an edge u—-> v, u appears before v in the ordering. 
  * Logic 
    - Create a indegree array
    - Fill indegree array
      ```
      for(int i = 0; i < V; i++) {
            for(Integer it : adj.get(i)) {
                indegree[it]++;
            }
      }
      int cnt = 0;
      ```
    - Create a queue and add node with indegree = 0
    - Do bfs call
    ```
    while(!queue.isEmpty()) {
            Integer node = queue.poll();
	    cnt++; 
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
       // if(cnt == V) return false;
       // return true;
    }
    ```
    - [Code](TopologicalSortUsingBFS.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Indegree array, queue data structure
    
 # Dijkstra's Algorithm | Shortest Path in Undirected Graphs
  * Logic 
    - Create a distance array
    - Fill distance array with Integer.MAX_VALUE
    - Create a PriorityQueue and add node with dist = 0
    ```
    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
     pq.add(new Node(s, 0));   
     while(pq.size() > 0) {
         Node node = pq.poll();

         for(Node it: adj.get(node.getV())) {
             if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                 dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
                 pq.add(new Node(it.getV(), dist[it.getV()]));
             }
         }
     }
    ```
    - [Code](DijkstraAlgorithm.java)
    - Time Complexity :  O((N+E)*logN). Going through N nodes and E edges and log N for priority queue
    - Space Complexity : O(N) + O(N) Space for Indegree array, queue data structure

# Kosaraju’s Algorithm for Strongly Connected Components(SCC)
  * Logic 
    - Create a stack fill by topo sort
    - Transpose a graph
    ```
    for (int i = 0; i < n; i++) 
			 transpose.add(new ArrayList<Integer>());
    for(int i = 0;i<n;i++) {
      vis[i] = 0; 
      for(Integer it: adj.get(i)) {
       transpose.get(it).add(i); 
      }
    }
    ```
    - do a dfs on stack filled by topo sort
    ```
    while(st.size() > 0) {
      int node = st.peek(); 
      st.pop(); 
      if(vis[node] == 0) {
       System.out.print("SCC: "); 
       revDfs(node, transpose, vis);
       System.out.println(); 
      }
		  }
    ```
    - [Code](Kosaraju’sAlgorithm.java)
    - Time Complexity :  O(N+E), DFS+TopoSort
    - Space Complexity : O(N+E), Transposing the graph
