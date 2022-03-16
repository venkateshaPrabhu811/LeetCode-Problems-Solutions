class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int ptr1 = 0;
        int ptr2 = 0;
        stk.push(pushed[ptr1++]);
        while(ptr2 < popped.length){
            if(!stk.isEmpty() && stk.peek() == popped[ptr2]){
                stk.pop();
                ptr2++;
            }
            else if(ptr1 < pushed.length){
                stk.push(pushed[ptr1++]);
            }
            else{
                break;
            }
        }
        return stk.isEmpty();
    }
}