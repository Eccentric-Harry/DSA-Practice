class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}

public class QueueLL{
    static Node start = null;
    static Node end = null;
    // push()
    public static void enqueue(int val){
        Node newNode = new Node(val);
        if(start == null){
            start = newNode;
            end = newNode;
            return;
        }
        end.next = newNode;
        end = newNode;
    }

    // pop()
    public static int dequeue(){
        if(start == null){
            return -1;
        }
        int data = start.val;
        start = start.next;

        if(start == null){
            end = null;
        }
        return data;
    }
}