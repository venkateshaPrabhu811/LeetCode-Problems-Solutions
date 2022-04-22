class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    Node root,counter;
    public MyHashMap() {
        root = new Node(-1,-1);
        counter = root;
    }
    
    public void put(int key, int value) {
        Node temp = root.next;
        while(temp != null){
            if(temp.key == key){
                temp.val = value;
                return;
            }
            temp = temp.next;
        }
        counter.next = new Node(key,value);
        counter = counter.next;
    }
    
    public int get(int key) {
        Node temp = root.next;
        while(temp != null){
            if(temp.key == key){
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node temp = root.next;
        while(temp != null){
            if(temp.key == key){
                temp.val = -1;
                return;
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */