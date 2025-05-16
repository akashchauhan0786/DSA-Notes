# 📊 Time and Space Complexity Cheat Sheet

This document summarizes the time and space complexities of common algorithms and data structures frequently used in DSA interviews.

---

## 1. Time Complexity Notation

| Notation | Description                       | Example           |
|----------|---------------------------------|-------------------|
| O(1)     | Constant time                   | Accessing array element by index |
| O(log N) | Logarithmic time                | Binary Search     |
| O(N)     | Linear time                    | Traversing array  |
| O(N log N) | Linearithmic time             | Efficient sorting (Merge Sort, Quick Sort avg) |
| O(N²)    | Quadratic time                 | Nested loops (Bubble Sort) |
| O(2^N)   | Exponential time               | Recursive Fibonacci (naive) |
| O(N!)    | Factorial time                 | Generating all permutations |

---

## 2. Time Complexity of Algorithms

| Algorithm                | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity |
|--------------------------|-----------------------|---------------------------|------------------------|------------------|
| Linear Search            | O(1)                  | O(N)                      | O(N)                   | O(1)             |
| Binary Search            | O(1)                  | O(log N)                  | O(log N)               | O(1)             |
| Bubble Sort              | O(N)                  | O(N²)                     | O(N²)                  | O(1)             |
| Selection Sort           | O(N²)                 | O(N²)                     | O(N²)                  | O(1)             |
| Insertion Sort           | O(N)                  | O(N²)                     | O(N²)                  | O(1)             |
| Merge Sort               | O(N log N)            | O(N log N)                | O(N log N)             | O(N)             |
| Quick Sort               | O(N log N)            | O(N log N)                | O(N²)                  | O(log N)         |
| Heap Sort                | O(N log N)            | O(N log N)                | O(N log N)             | O(1)             |
| Counting Sort            | O(N + K)              | O(N + K)                  | O(N + K)               | O(K)             |
| Radix Sort               | O(d * (N + K))        | O(d * (N + K))            | O(d * (N + K))         | O(N + K)         |

---

## 3. Time Complexity of Data Structures Operations

| Data Structure     | Access | Search | Insertion | Deletion | Space Complexity |
|--------------------|--------|--------|-----------|----------|------------------|
| Array              | O(1)   | O(N)   | O(N)      | O(N)     | O(N)             |
| Linked List        | O(N)   | O(N)   | O(1)      | O(1)     | O(N)             |
| Stack              | O(N)   | O(N)   | O(1)      | O(1)     | O(N)             |
| Queue              | O(N)   | O(N)   | O(1)      | O(1)     | O(N)             |
| Hash Table (HashMap)| N/A   | O(1)*  | O(1)*     | O(1)*    | O(N)             |
| Binary Search Tree | O(log N)| O(log N)| O(log N) | O(log N) | O(N)             |
| Balanced BST (AVL, Red-Black)| O(log N)| O(log N)| O(log N)| O(log N)| O(N)          |
| Heap               | O(N)   | O(N)   | O(log N)  | O(log N) | O(N)             |

\* Average case, worst case can degrade to O(N)

---

## 4. Time Complexity of Graph Algorithms

| Algorithm           | Time Complexity                         | Space Complexity   |
|---------------------|---------------------------------------|-------------------|
| BFS (Adjacency List)| O(V + E)                              | O(V)              |
| DFS (Adjacency List)| O(V + E)                              | O(V)              |
| Dijkstra’s (Heap)   | O((V + E) log V)                      | O(V)              |
| Bellman-Ford        | O(V * E)                             | O(V)              |
| Floyd-Warshall      | O(V³)                                | O(V²)             |
| Kruskal’s MST       | O(E log E)                          | O(V)              |
| Prim’s MST (Heap)   | O(E log V)                          | O(V)              |

---

## 5. Space Complexity Notes

- **Auxiliary space** refers to extra space or temporary space used by an algorithm.
- Space used by inputs/outputs is usually not counted.
- Recursive algorithms often have space overhead due to function call stack.

---

## 6. Common Examples

| Algorithm                  | Time Complexity | Space Complexity |
|----------------------------|-----------------|------------------|
| Recursive Fibonacci (naive) | O(2^N)          | O(N)             |
| DP Fibonacci (Memo/Tab)     | O(N)            | O(N)             |
| Matrix Multiplication       | O(N³)           | O(1) or O(N²)    |
| String Matching (Naive)     | O(N*M)          | O(1)             |
| KMP Pattern Matching        | O(N + M)        | O(M)             |

---

# References

- [Big-O Notation](https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/)
- [GeeksforGeeks - Time and Space Complexity](https://www.geeksforgeeks.org/analysis-of-algorithms-set-1-asymptotic-analysis/)
- [CLRS - Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)

---

*Happy Coding!* 🚀
