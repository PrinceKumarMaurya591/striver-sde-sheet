package Graph.Graph2;

import java.util.Arrays;

public class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        KruskalsAlgorithm ka = new KruskalsAlgorithm();
        int V = 4;
        Edge[] edges = {
            new Edge(0, 1, 10), new Edge(0, 2, 6),
            new Edge(0, 3, 5), new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        };

        int mstWeight = ka.kruskalsMST(V, edges);
        System.out.println("MST weight: " + mstWeight);
    }

    // Function to find MST weight using Kruskal's Algorithm.
    // Time complexity: O(E log E), Space: O(V).

    // Approach: Sort edges by weight. Use Union-Find (DSU) to
    // detect cycles. Process edges from smallest to largest.
    // If adding an edge doesn't create a cycle, include it.
    public int kruskalsMST(int V, Edge[] edges) {
        Arrays.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int mstWeight = 0;
        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                mstWeight += edge.weight;
                union(parent, rank, rootSrc, rootDest);
            }
        }

        return mstWeight;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int[] rank,
                       int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }

}
