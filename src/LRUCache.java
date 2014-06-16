import java.util.HashMap;

/**
 * Created by tianlan on 6/16/2014.
 */
public class LRUCache {
    //node class for the double linked list
    class Node
    {
        Node pre, next;
        int key;
        int val;
        public Node(int key, int value)
        {
            this.key = key;
            this.val = value;
        }
    }

    private int capacity;
    private int num;
    private HashMap<Integer, Node> map;
    private Node first, last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0; //how many items
        map = new HashMap<Integer, Node>();
        first = null; //oldest
        last = null; //newest
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;
        else if(node!=last) //move the node to the last (because it is "new" now)
        {
            if(node == first)
                first = first.next;
            else
                node.pre.next = node.next;
            node.next.pre = node.pre;
            last.next = node;
            node.pre = last;
            node.next = null;
            last = node;
        }
        return node.val;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null){ //update
            node.val = value;
            if (node != last){ //move the node to the last (because it is "new" now)
                if (node == first){
                    first = first.next;
                }
                else{
                    node.pre.next = node.next;
                }
                node.next.pre = node.pre;
                last.next = node;
                node.pre = last;
                node.next = null;
                last = node;
            }
        }
        else{ //add
            Node newNode = new Node(key,value);
            //if full, delete least used item
            if(num >= capacity){
                map.remove(first.key);
                first = first.next;
                if (first!=null) first.pre = null;
                else last = null;
                num --;
            }
            //add the new item
            if (first == null || last == null){
                first = newNode;
            }
            else {
                last.next = newNode;
            }
            newNode.pre = last;
            last = newNode;
            map.put(key, newNode);
            num ++;
        }
    }
}
