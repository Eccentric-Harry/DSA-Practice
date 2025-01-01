import java.util.*;
import java.time.LocalDate;

public class Main {
    public static LocalDate currentDate = LocalDate.now();
    public static void main(String[] args) {
        // Create a sample tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // Create an instance of the class containing levelOrder method
        Main obj = new Main();
        List<List<String>> result = obj.levelOrder(root);
        
        // Print the result
        for (List<String> level : result) {
            System.out.println(level);
        }
    }

    public List<List<String>> levelOrder(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<String> li = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    li.add(String.valueOf(curr.val));
                    q.offer(curr.left);
                    q.offer(curr.right);
                } else {
                    li.add("null");
                }
            }

            list.add(li);
        }
        return list;
    }
    public boolean isSymmetric(TreeNode root) {
        List<List<String>> li = luvelOrder(root);
        for(int i = 1; i < li.length; i++){
            if(!reverse(li.get(i))){
                return false;
            }
        }
        return true;

    }
    public boolean reverse(List<String> li){
        int n = li.length();
        for(int i =  0; i< li.length; i++){
            if(li.get(i) != li.get(n-i-1)){
                return false;
            }
        }
        return true;
    }

}


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
