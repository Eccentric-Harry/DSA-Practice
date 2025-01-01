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
    Node node;
    int level;

    public Tuple(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class TopView {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list; 
        Queue<Tuple> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            Node node = curr.node;
            int level = curr.level;
            map.putIfAbsent(level,node.data);
            // map.put(level, node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, level - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, level + 1));
            }
        }

        ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for (Integer key : sortedKeys) {
            list.add(map.get(key));
        }

        return list;
    }
}
