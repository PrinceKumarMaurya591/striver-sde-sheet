package Graph.Graph1;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        BFS bfs = new BFS();
        // Graph: 5 nodes (0-4), edges shown below
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0-1, 0-2, 1-3, 1-4
        adj.get(0).add(1); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(1).add(4);

        List<Integer> result = bfs.bfsOfGraph(V, adj);
        System.out.println("BFS: " + result);
    }

    // Function to perform BFS traversal of a graph from node 0.
    // Time complexity: O(V + E), Space complexity: O(V).

    // Approach: Use a queue. Start from node 0, mark it visited,
    // and add it to the queue. While the queue is not empty,
    // poll a node, add it to result, and add all its unvisited
    // neighbors to the queue.
    public List<Integer> bfsOfGraph(int V,
                                    List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

}
