class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    int flag;
    int size;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
        flag = 1;
        size = 0;
    }
    
    public void push(int x) {
        size++;
        if(flag == 1){
            stk1.push(x);
        }
        else{
            while(!stk2.isEmpty()){
                stk1.push(stk2.pop());
            }
            flag = 1;
            stk1.push(x);
        }
    }
    
    public int pop() {
        size--;
        if(flag != 1){
            return stk2.pop();
        }
        else{
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
            flag = 0;
            return stk2.pop();
        }
    }
    
    public int peek() {
        if(flag == 1){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
            flag = 0;
            return stk2.peek();
        }
        else return stk2.peek();
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */