class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(int data, Node prev, Node next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    } 
}

public class ArrayTo2DLL{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;
        Node head = new Node(arr[0], null, null);
        Node prev = head;
        for(int i = 1; i <n; i++){
            prev.next = new Node(arr[i], prev, null);
            prev = prev.next;
        }
        printList(head);
        System.out.println(prev.prev.data);

    }
    public static Node printList(Node head){
        Node temp = head;
        if(head == null){
            return head;
        }
        while(temp!=null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
        return head;
    }
}
