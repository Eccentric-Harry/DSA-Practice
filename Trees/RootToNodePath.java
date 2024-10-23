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

public class RootToNodePath {
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root, TreeNode target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        path(root, target, list, new ArrayList<>());
        return list;
    }

    public static void path(TreeNode node, TreeNode target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> li) {
        if (node == null) {
            return;
        }
        
        li.add(node.val);
        
        if (node == target) {
            list.add(new ArrayList<>(li)); 
            li.remove(li.size() - 1); 
            return;
        }
        
        path(node.left, target, list, li);
        path(node.right, target, list, li);
        
        // Backtrack by removing the last element from the path
        li.remove(li.size() - 1);
    }
    
    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode target = root.left.right; // Target node with value 5

        ArrayList<ArrayList<Integer>> paths = Paths(root, target);
        System.out.println(paths);
    }
}
