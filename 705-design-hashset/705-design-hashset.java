class MyHashSet {
    int[] hs;
    public MyHashSet() {
        hs = new int[1_000_001];
    }
    
    public void add(int key) {
        hs[key] = 1;
    }
    
    public void remove(int key) {
        hs[key] = 0;
    }
    
    public boolean contains(int key) {
        return hs[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */