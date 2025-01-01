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

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int _row, int _col) {
        this.node = _node;
        this.row = _row;
        this.col = _col;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to store columns, rows, and node values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue to facilitate level order traversal
        Queue<Tuple> q = new LinkedList<Tuple>();
        
        // Start BFS from the root at position (0, 0)
        q.offer(new Tuple(root, 0, 0));

        // Process the queue
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // Insert the node value into the TreeMap
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            // Traverse the left child
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Traverse the right child
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the final result list
        List<List<Integer>> list = new ArrayList<>();

        // Extract elements from the map in vertical order
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }
    public static void main(String[] args){

    }
}


