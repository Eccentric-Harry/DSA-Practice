class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
public class LinkedList{
    public static Node printList(Node head){
        Node temp = head;
        if(head == null){
            return head;
        }
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
        return head;
    }
    public static Node removeAtk(Node head, int k){
        if(head == null){
            return head;
        }
        if(k==1){
            head = head.next;
            return head;
        }
        int count = 1;
        Node temp = head;
        while(count < k && temp!=null){
            count++;
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(4);
        System.out.println("Original List: ");
        printList(head);
        head = removeAtk(head, 3);
        System.out.println("List after removing 3rd element: ");
        printList(head);
    }
}