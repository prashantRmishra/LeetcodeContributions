// we can easily do it with two queue,
// we will do it with one queue
class MyStack {
    Queue<Integer> q ;
    public MyStack() {
        q  = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        if(q.size()>1){
            int size = q.size();
            int index =0;
            while(index!=size-1){//just re-push size-1 value again it will insure that the value 
                // that needs to be poped is at head;
                q.add(q.remove());
                index++;
            }
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */