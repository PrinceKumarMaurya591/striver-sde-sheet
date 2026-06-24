package Graph.Graph2;

import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        PrimsAlgorithm pa = new PrimsAlgorithm();
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0-1(2), 0-3(6), 1-2(3), 1-3(8), 1-4(5), 2-4(7)
        adj.get(0).add(new Edge(1, 2)); adj.get(0).add(new Edge(3, 6));
        adj.get(1).add(new Edge(2, 3)); adj.get(1).add(new Edge(3, 8));
        adj.get(1).add(new Edge(4, 5));
        adj.get(2).add(new Edge(4, 7));

        int mstWeight = pa.primsMST(V, adj);
        System.out.println("MST weight: " + mstWeight);
    }

    // Function to find the Minimum Spanning Tree weight using
    // Prim's Algorithm.
    // Time complexity: O((V+E) log V), Space: O(V).

    // Approach: Use a min-heap. Start from node 0. Track visited
    // nodes. For each node popped from the heap, add its weight
    // to the MST. For each unvisited neighbor, push it to the
    // heap with the edge weight.
    public int primsMST(int V, List<List<Edge>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // {node, weight}
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            mstWeight += weight;

            for (Edge edge : adj.get(node)) {
                if (!visited[edge.to]) {
                    pq.offer(new int[]{edge.to, edge.weight});
                }
            }
        }

        return mstWeight;
    }

}
