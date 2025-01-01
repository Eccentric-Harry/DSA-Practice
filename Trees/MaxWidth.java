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

class Tuple{
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class MaxWidth{
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> li = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int row = t.row;
            int col = t.col;
            TreeNode node = t.node;

            map.putIfAbsent(row, new TreeMap<>());
            map.get(row).putIfAbsent(col , new PriorityQueue<Integer>());
            map.get(row).get(col).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left,row-1, col+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,row+1, col+1));
            }
        }
        
        
    }
    public static int levels(TreeNode node, int c) {
        if (node == null) {
            return c;
        }
        int leftDepth = levels(node.left, c + 1);
        int rightDepth = levels(node.right, c + 1);

        return Math.max(leftDepth, rightDepth);
    }
    public static int widthOfBinaryTree(TreeNode root) {
        int levels = levels(root, 0);
        int leafNodes = (int) Math.pow(2,levels-1);
        return leafNodes - 
    }
}