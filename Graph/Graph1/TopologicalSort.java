package Graph.Graph1;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 5->0, 5->2, 4->0, 4->1, 2->3, 3->1
        adj.get(5).add(0); adj.get(5).add(2);
        adj.get(4).add(0); adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> result = ts.topologicalSort(V, adj);
        System.out.println("Topological order: " + result);
    }

    // Function to perform topological sort using Kahn's
    // Algorithm (BFS with indegree tracking).
    // Time complexity: O(V + E), Space complexity: O(V).

    // Approach: Compute indegree of each node. Add all nodes
    // with indegree 0 to a queue. While the queue is not empty,
    // remove a node, add it to result, and reduce the indegree
    // of its neighbors. If any neighbor's indegree becomes 0,
    // add it to the queue.
    public List<Integer> topologicalSort(int V,
                                         List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

}
