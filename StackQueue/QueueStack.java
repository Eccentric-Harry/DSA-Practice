import java.util.Stack;
public class QueueStack{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public viod enqueue(int val){
        int size1 = s1.size();
        
        for(int i = 0; i < size1; i++){
            s2.push(s1.pop());
        }
        s1.push(val);
        int size2 = s2.size();
        for(int i = 0; i < size2; i++){
            s1.push(s2.pop());
        }
    }
    public int dequeue(){
        if(s1.isEmpty()){
            return -1;
        }
        return s1.pop();
    }
}