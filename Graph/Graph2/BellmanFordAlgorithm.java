package Graph.Graph2;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm bf = new BellmanFordAlgorithm();
        int V = 5;
        Edge[] edges = {
            new Edge(0, 1, -1), new Edge(0, 2, 4),
            new Edge(1, 2, 3),  new Edge(1, 3, 2),
            new Edge(1, 4, 2),  new Edge(3, 2, 5),
            new Edge(3, 1, 1),  new Edge(4, 3, -3)
        };

        int[] dist = bf.bellmanFord(V, edges, 0);
        System.out.println("Distances from 0: "
                + Arrays.toString(dist));
    }

    // Function to find shortest paths (handles negative edges).
    // Time complexity: O(V * E), Space complexity: O(V).

    // Approach: Relax all edges V-1 times. For each edge (u,v,w),
    // if dist[u] + w < dist[v], update dist[v]. After V-1
    // iterations, do one more pass to detect negative cycles.
    public int[] bellmanFord(int V, Edge[] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE &&
                    dist[edge.src] + edge.weight <
                            dist[edge.dest]) {
                    dist[edge.dest] =
                            dist[edge.src] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE &&
                dist[edge.src] + edge.weight <
                        dist[edge.dest]) {
                System.out.println("Negative cycle detected");
                return new int[]{-1};
            }
        }

        return dist;
    }

}
