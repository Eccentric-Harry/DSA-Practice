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

public class ArrayToLL{
    public static void main( String[] args){
        int[] arr = {1,2,3,4,5};
        Node head = new Node(arr[0]);
        System.out.println("Linked List: ");
        System.out.print(head.data + "->");
        Node temp = head;
        for(int i = 1; i < arr.length; i++){
            temp.next = new Node(arr[i]);
            System.out.print(temp.next.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}




