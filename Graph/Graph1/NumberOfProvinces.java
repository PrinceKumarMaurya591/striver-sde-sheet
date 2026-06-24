package Graph.Graph1;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        // 3 cities: 0-1 connected, 2 isolated
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int provinces = np.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + provinces);
    }

    // Function to find the number of provinces (connected
    // components) in a graph represented by an adjacency matrix.
    // Time complexity: O(n^2), Space complexity: O(n).

    // Approach: Use DFS. For each unvisited city, start a DFS
    // to visit all cities in its connected component. Increment
    // the province count for each new DFS.
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected,
                     boolean[] visited, int city) {
        visited[city] = true;
        for (int neighbor = 0;
             neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 &&
                    !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }

}
