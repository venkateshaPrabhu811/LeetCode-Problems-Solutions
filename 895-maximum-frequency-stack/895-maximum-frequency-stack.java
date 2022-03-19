class FreqStack {
    private HashMap<Integer,Integer> freq;
    private HashMap<Integer,Stack<Integer>> freqStk;
    private int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        freqStk = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0)+1);
        freqStk.computeIfAbsent(freq.get(val),s->new Stack<>()).add(val);
        maxFreq = Math.max(maxFreq,freq.get(val));
    }
    
    public int pop() {
        int value = freqStk.get(maxFreq).pop();
        if(freqStk.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        freq.put(value,freq.getOrDefault(value,0)-1);
        return value;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */