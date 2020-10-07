package PracticeProblems;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    Node head = new Node();
    Node tail = new Node();

    LinkedList<Node> linkedList = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            addNode(node);
        } else {
            return -1;
        }
        return node.value;
    }

    public void put(int key, int value) {


        if (map.size() == capacity && map.get(key) == null) {
            Node nodeRemove = map.remove(tail.prev.key);
            remove(nodeRemove);
        }
        Node node = null;
        if(map.get(key) != null){
            node = map.get(key);
            node.value = value;
            remove(node);
            addNode(node);
        }else{
            node = new Node(key, value);
            addNode(node);
        }

        map.put(key, node);

    }

    public void addNode(Node node) {
        Node head_next = head.next;
        node.next = head_next;
        node.prev = head;
        head_next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

class Node {

    int key;
    int value;
    Node prev;
    Node next;

    Node() {

    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Test {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */