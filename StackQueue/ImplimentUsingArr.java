public class ImplimentUsingArr{
    private int[] arr;
    private int top;
    public ImplimentUsingArr(int size){
        arr = new int[size];
        top = -1;
    }
    public void push(int data){
        if(top == arr.length-1){
            System.out.println("Stack is full");
        }
        top++;
        arr[top] = data;
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        int data = arr[top];
        top--;
        return data;
    }
    public int peek(){
        if(top == -1){
            return -1;
        }
        return arr[top];
    }
    public static void main(String[] args){
        ImplimentUsingArr obj = new ImplimentUsingArr(5);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }
}