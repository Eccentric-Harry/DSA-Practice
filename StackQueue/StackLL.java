class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLL {
    Node top = null;  

    public void push(int value) {
        Node newNode = new Node(value);  
        if (top == null) {  
            top = newNode;
        } else {
            newNode.next = top;  // New node points to the current top
            top = newNode;  // Update top to the new node
        }
    }

    // Function to pop an element from the stack and return it
    public int pop() {
        if (top == null) {  // Stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.data;  // Get the data from the top node
        top = top.next;  // Update top to the next node
        return data;
    }

    // Function to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Function to peek at the top element without removing it
    public int peek() {
        if (top == null) {  // Stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());  // Output: 30
        System.out.println("Popped: " + stack.pop());  // Output: 30
        System.out.println("Top element: " + stack.peek());  // Output: 20
    }
}
