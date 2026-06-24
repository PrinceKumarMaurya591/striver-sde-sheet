package Graph.Graph1;

import java.util.*;

public class CycleDetectionDirected {

    public static void main(String[] args) {
        CycleDetectionDirected cd =
                new CycleDetectionDirected();
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0->1, 1->2, 2->3, 3->1 (creates cycle)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        boolean hasCycle = cd.isCyclic(V, adj);
        System.out.println("Has cycle: " + hasCycle);
    }

    // Function to detect a cycle in a directed graph using DFS.
    // Time complexity: O(V + E), Space complexity: O(V).

    // Approach: Use two boolean arrays: visited and recStack
    // (recursion stack). During DFS, if we encounter a node
    // that is already in the recursion stack, there is a cycle.
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsDetect(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsDetect(int node, boolean[] visited,
                              boolean[] recStack,
                              List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsDetect(neighbor, visited,
                              recStack, adj)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // Back edge found
            }
        }

        recStack[node] = false;
        return false;
    }

}
