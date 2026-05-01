class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public void insertAfterHead(Node node){
        Node nodeAfterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = nodeAfterHead;
        nodeAfterHead.prev = node;
    }
    
    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node node = tail.prev;
                removeNode(node);
                map.remove(node.key);
            }
            Node newNode = new Node(key,value);
            insertAfterHead(newNode);
            map.put(key,newNode);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */