package BinaryTrees.BinaryTrees2;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        VerticalOrderTraversal vot = new VerticalOrderTraversal();
        // Tree: 3 -> 9, 20 -> null, null, 15, 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = vot.verticalTraversal(root);
        System.out.println("Vertical order: " + result);
    }

    // Function to perform vertical order traversal. Nodes are
    // grouped by their horizontal distance from the root.
    // Time complexity: O(n log n), Space complexity: O(n).

    // Approach: Use a TreeMap to store nodes by their horizontal
    // distance. Perform a level order traversal with a queue,
    // tracking each node's horizontal distance. The TreeMap
    // automatically sorts by horizontal distance.
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store nodes by horizontal distance
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // Queue for level order traversal with horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd; // horizontal distance

            map.computeIfAbsent(hd,
                    k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }

    private static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

}
