package Recursion.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static void main(String[] args) {
        RatInAMaze rm = new RatInAMaze();
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> paths = rm.findPath(maze);
        System.out.println("Paths: " + paths);
    }

    // Function to find all possible paths for a rat from
    // top-left (0,0) to bottom-right (n-1,n-1) in a maze.
    // The rat can move in four directions: D, L, R, U.
    // 1 represents open cell, 0 represents blocked cell.
    // Time complexity: O(4^(n^2)), Space complexity: O(n^2).

    // Approach: Use backtracking with DFS. Start from (0,0).
    // Try all four directions (D, L, R, U). If the next cell
    // is within bounds, not blocked, and not visited, move
    // to it and recurse. Backtrack when hitting a dead end.
    public List<String> findPath(int[][] maze) {
        List<String> result = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        backtrack(result, "", maze, visited, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String path,
                           int[][] maze, boolean[][] visited,
                           int row, int col, int n) {
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Directions: D, L, R, U
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < n &&
                maze[newRow][newCol] == 1 &&
                !visited[newRow][newCol]) {

                visited[newRow][newCol] = true;
                backtrack(result, path + dir[i], maze,
                        visited, newRow, newCol, n);
                visited[newRow][newCol] = false;
            }
        }
    }

}
