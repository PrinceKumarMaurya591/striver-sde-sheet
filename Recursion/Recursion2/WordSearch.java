package Recursion.Recursion2;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean exists = ws.exist(board, word);
        System.out.println("Word exists: " + exists);
    }

    // Function to check if a word exists in a grid of characters.
    // The word can be formed by adjacent cells (horizontally or
    // vertically). The same cell cannot be used more than once.
    // Time complexity: O(m * n * 4^L), Space complexity: O(L)
    // where L is the length of the word.

    // Approach: Use backtracking DFS. For each cell matching the
    // first character, start a DFS search. Mark visited cells by
    // temporarily modifying them. Explore all four directions.
    // If the word is found, return true.
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {
        if (index == word.length()) return true;

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark as visited by replacing with a special char
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        // Restore the original character
        board[row][col] = temp;

        return found;
    }

}
