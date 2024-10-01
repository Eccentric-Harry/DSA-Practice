public class QueueArr {
    int[] arr;
    int front = -1;
    int rear = -1;
    int currSize = 0;
    public QueueArr(int size) {
        arr = new int[size];
    }
    public void enqueue(int data) {
        if (currSize > arr.length) { 
            System.out.println("The Queue is Full");
            return;
        }
        if (front == -1) {  
            front = 0;
            rear = 0;
        }
        rear = (rear+1)%arr.length;
        arr[rear] = data;
        currSize++;
    }

    public int dequeue() {
        if (front == -1 || front > rear) {  
            System.out.println("The Queue is Empty");
            return -1;
        }
        int data = arr[front];
        front++;
        return data;
    }

    public static void main(String[] args) {
        QueueArr obj = new QueueArr(5);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
    }
}
