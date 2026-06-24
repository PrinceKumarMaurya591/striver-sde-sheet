package Graph.Graph2;

import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        DijkstraAlgorithm da = new DijkstraAlgorithm();
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0-1(2), 0-3(1), 1-2(4), 1-3(3), 3-4(5), 2-4(1)
        adj.get(0).add(new Edge(1, 2)); adj.get(0).add(new Edge(3, 1));
        adj.get(1).add(new Edge(2, 4)); adj.get(1).add(new Edge(3, 3));
        adj.get(3).add(new Edge(4, 5));
        adj.get(2).add(new Edge(4, 1));

        int[] dist = da.dijkstra(V, adj, 0);
        System.out.println("Distances from 0: " + Arrays.toString(dist));
    }

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Function to find shortest paths from source to all nodes.
    // Time complexity: O((V+E) log V), Space: O(V).

    // Approach: Use a min-heap (PriorityQueue). Initialize all
    // distances to infinity except source (0). While the heap
    // is not empty, pop the node with smallest distance, and
    // relax all its edges. If a shorter path is found, update
    // and push to the heap.
    public int[] dijkstra(int V, List<List<Edge>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            if (currDist > dist[node]) continue;

            for (Edge edge : adj.get(node)) {
                int newDist = currDist + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.offer(new int[]{edge.to, newDist});
                }
            }
        }

        return dist;
    }

}
