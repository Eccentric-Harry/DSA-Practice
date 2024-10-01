class Node{
    int value;
    Node next;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}

public class StackLL{
    Node top = null;
    // push()

    public static void push(int val){
        Node newNode = new Node(val);
        if(top == null){
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    // pop()

    public static int pop(){
        if(top == null){
            return -1;
        }
        int data = top.value;
        top = top.next;
        return data;
    }
    public static boolean isEmpty(){
        return top==null;
    }
    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return top.value;
    }
}