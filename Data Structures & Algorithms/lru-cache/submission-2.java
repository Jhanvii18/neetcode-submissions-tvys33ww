class Node
{
    int key,val;
    Node prev,next;
    Node(int k , int v)
    {
        key=k;
        val=v;
    }
}
class LRUCache 
{
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head,tail;//dummies
    public LRUCache(int capacity) 
    {
        this.capacity=capacity;
        map = new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    private void insert(Node node)
    {
        //cosidering head as node not pointer
        node.next=head.next;
        head.next=node;
        node.prev=head;
        node.next.prev=node;
    }
    private void remove(Node node)
    {
        //considering tail as a node thats why
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) 
    {
        if(!map.containsKey(key))
        return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        Node node = new Node(key,value);
        map.put(key,node);
        insert(node);
        if(map.size()>capacity)
        {
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
