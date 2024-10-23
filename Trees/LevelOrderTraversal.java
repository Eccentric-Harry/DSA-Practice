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

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 

        while (!q.isEmpty()) {
            int levelSize = q.size(); 
            List<Integer> li = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {  
                TreeNode curr = q.poll(); 
                li.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            list.add(li);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);  // Output: [[1], [2, 3], [4, 5]]
    }
}
