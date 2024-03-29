class MyHashSet {
    Entry[] bucket;
    int size = 1000;
    public MyHashSet() {
        bucket = new Entry[size];
    }
    
    public void add(int key) {
        Entry entry = bucket[key%size];
        if(entry == null){
            bucket[key%size] = new Entry(key,null);
            return;
        }
        Entry prev = null;
        while(entry != null){
            if(entry.val == key) return;
            prev = entry;
            entry = entry.next;    
        }
        prev.next = new Entry(key,null);
    }
    
    public void remove(int key) {
        Entry entry = bucket[key%size];
        if(entry == null) return;
        Entry prev = null;
        while(entry != null){
            if(entry.val == key){
                if(prev == null){
                    bucket[key%size] = entry.next;
                }
                else{
                    prev.next = entry.next;
                }
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }
    
    public boolean contains(int key) {
        Entry entry = bucket[key%size];
        if(entry == null) return false;
        while(entry != null){
            if(entry.val == key){
                return true;
            }
            entry = entry.next;
        }
        return false;
    }
}
class Entry{
    int val;
    Entry next;
    Entry(int val,Entry next){
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */