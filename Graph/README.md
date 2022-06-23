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

# Cycle Detection
  * BFS
    - [Code](bfs.java)
    - Time Complexity : O(N+E)
      N = Nodes , E = travelling through adjacent nodes
    - Space Complexity : O(N) + O(N) Space for Visited array, queue data structure
