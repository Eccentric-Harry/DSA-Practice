import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple{
    int index;
    TreeNode node;

    public Tuple(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

public class DiameterOfTree{
    public static int diameterOfTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));
        int maxLen = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int len = 0;
            for(int i = 0; i < size; i++){
                Tuple t = q.poll();
                TreeNode node = t.node;
                int index = t.index;

                int ll = leftLength(node,0);
                int rl = rightLength(node,0);
                len =ll+rl;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
        
    }
    public static int leftLength(TreeNode node, int c){
        if(node == null){
            return c;
        }
        return levels(nodes.left, c+1);
    }
    public static int rightLength(TreeNode node, int c){
        if(node == null){
            return c;
        }
        return rightLength(node,c+1);
    }
}