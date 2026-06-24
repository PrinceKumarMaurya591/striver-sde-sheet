package BinaryTrees.BinaryTrees3;

import BinaryTrees.BinaryTrees1.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    public static void main(String[] args) {
        SerializeDeserialize sd = new SerializeDeserialize();
        // Tree: 1 -> 2, 3 -> null, null, 4, 5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = sd.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = sd.deserialize(serialized);
        System.out.println("Deserialized root: " + deserialized.val);
    }

    // Function to serialize a binary tree to a string using
    // level order traversal. Null nodes are marked as "null".
    // Time complexity: O(n), Space complexity: O(n).

    // Function to deserialize a string back to a binary tree.
    // Time complexity: O(n), Space complexity: O(n).

    // Approach for serialize: Use level order traversal (BFS).
    // Append each node's value (or "null" for null nodes) to
    // a StringBuilder, separated by commas.

    // Approach for deserialize: Split the string by commas.
    // Use a queue. The first element is the root. For each
    // node, the next two elements are its left and right
    // children (which may be "null").
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split(",");
        if (values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode parent = queue.poll();

            // Process left child
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(
                        Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }

            // Process right child
            if (i + 1 < values.length &&
                    !values[i + 1].equals("null")) {
                TreeNode right = new TreeNode(
                        Integer.parseInt(values[i + 1]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

}
