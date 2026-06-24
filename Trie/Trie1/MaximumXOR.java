package Trie.Trie1;

public class MaximumXOR {

    // Binary Trie node
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root;

    public static void main(String[] args) {
        MaximumXOR mx = new MaximumXOR();
        int[] nums = {3, 10, 5, 25, 2, 8};

        int maxXor = mx.findMaximumXOR(nums);
        System.out.println("Maximum XOR: " + maxXor);
    }

    // Function to find the maximum XOR of any two numbers.
    // Time complexity: O(n * 32), Space complexity: O(n * 32).

    // Approach: Insert all numbers into a binary trie (32-bit).
    // For each number, find the number in the trie that gives
    // the maximum XOR by trying to go to the opposite bit at
    // each position. The maximum XOR for the current number
    // is built bit by bit.
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        int maxXor = 0;

        // Insert all numbers into the trie
        for (int num : nums) {
            insert(num);
        }

        // Find max XOR for each number
        for (int num : nums) {
            maxXor = Math.max(maxXor, findMaxXor(num));
        }

        return maxXor;
    }

    private void insert(int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    private int findMaxXor(int num) {
        TrieNode curr = root;
        int xor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            // Try to go to the opposite bit for maximum XOR
            int oppositeBit = 1 - bit;

            if (curr.children[oppositeBit] != null) {
                xor |= (1 << i);
                curr = curr.children[oppositeBit];
            } else {
                curr = curr.children[bit];
            }
        }

        return xor;
    }

}
