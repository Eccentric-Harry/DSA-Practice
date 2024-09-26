import java.util.Queue;
public class StackQueue{
    Queue<Integer> q = new LinkedList<>();
    public void push(int val){
        if(q.isEmpty()){
            q.add(val);
            return;
        }
        q.add(val);
        int size = q.size();
        for(int i = 0; i < size-1; i++){
            q.add(q.poll());
        }
    }
    public int pop(){
        if(q.isEmpty()){
            return -1;
        }
        return q.remove();
    }
    public int top(){
        if(q.isEmpty()){
            return -1;
        }
        return q.peek();
    }
}