class Node implements Comparator < Node > {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {}

    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}

class Main {
    void primsAlgo(ArrayList < ArrayList < Node >> adj, int N) {
        int dis[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            dis[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        PriorityQueue < Node > pq = new PriorityQueue < Node > (N, new Node());

        dis[0] = 0;
        parent[0] = -1;
        pq.add(new Node(dis[0], 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;

            for (Node it: adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < dis[it.getV()]) {
                    parent[it.getV()] = u;
                    dis[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), dis[it.getV()]));
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}
