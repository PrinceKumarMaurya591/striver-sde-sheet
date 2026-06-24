package Graph.Graph1;

import java.util.*;

public class CycleDetectionUndirected {

    public static void main(String[] args) {
        CycleDetectionUndirected cd =
                new CycleDetectionUndirected();
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0-1, 1-2, 2-3, 3-1 (creates cycle)
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(1); adj.get(1).add(3);

        boolean hasCycle = cd.isCycle(V, adj);
        System.out.println("Has cycle: " + hasCycle);
    }

    // Function to detect a cycle in an undirected graph.
    // Time complexity: O(V + E), Space complexity: O(V).

    // Approach: Use BFS. For each unvisited node, start a BFS.
    // Track the parent of each node. If we encounter a visited
    // neighbor that is not the parent, there is a cycle.
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsDetect(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsDetect(int start, boolean[] visited,
                              List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

}
