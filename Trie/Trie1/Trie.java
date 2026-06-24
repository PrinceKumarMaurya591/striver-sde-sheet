package Trie.Trie1;

public class Trie {

    // Trie node class
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search apple: "
                + trie.search("apple"));   // true
        System.out.println("Search app: "
                + trie.search("app"));     // false
        System.out.println("StartsWith app: "
                + trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println("Search app: "
                + trie.search("app"));     // true
    }

    // Trie (Prefix Tree) implementation supporting insert,
    // search, and startsWith operations.
    // Time complexity: O(L) for all operations, where L is
    // the length of the word.

    // Approach: Each node has 26 child pointers (for 'a'-'z')
    // and a boolean flag indicating end of word.
    // - insert: traverse characters, create nodes as needed,
    //   mark the last node as end of word.
    // - search: traverse characters, if any node is missing
    //   return false, else return isEndOfWord of last node.
    // - startsWith: traverse characters, if any node is
    //   missing return false, else return true.

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

}
