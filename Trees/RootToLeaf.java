import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RootToLeaf {
    // Method to find all paths from root to leaf nodes
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findLeafPaths(root, result, new ArrayList<>());
        return result;
    }

    // Helper method to recursively find paths to leaf nodes
    public static void findLeafPaths(TreeNode node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath) {
        if (node == null) {
            return;
        }

        // Add current node's value to the path
        currentPath.add(node.val);
        
        // Check if the node is a leaf node (both children are null)
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath)); // Add a copy of the current path to the result list
        } else {
            // Recursively explore left and right subtrees
            findLeafPaths(node.left, result, currentPath);
            findLeafPaths(node.right, result, currentPath);
        }

        // Backtrack to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> leafPaths = Paths(root);
        System.out.println(leafPaths);
    }
}
