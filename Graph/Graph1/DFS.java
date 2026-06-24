package Graph.Graph1;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        DFS dfs = new DFS();
        // Graph: 5 nodes (0-4)
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 0-1, 0-2, 1-3, 1-4
        adj.get(0).add(1); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(1).add(4);

        List<Integer> result = dfs.dfsOfGraph(V, adj);
        System.out.println("DFS: " + result);
    }

    // Function to perform DFS traversal of a graph from node 0.
    // Time complexity: O(V + E), Space complexity: O(V).

    // Approach: Use recursion. Start from node 0, mark it
    // visited, add to result, and recursively visit all its
    // unvisited neighbors.
    public List<Integer> dfsOfGraph(int V,
                                    List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsHelper(0, visited, adj, result);
        return result;
    }

    private void dfsHelper(int node, boolean[] visited,
                           List<List<Integer>> adj,
                           List<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, adj, result);
            }
        }
    }

}
