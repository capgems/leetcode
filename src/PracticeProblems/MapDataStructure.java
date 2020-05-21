package PracticeProblems;

import java.util.*;

public class MapDataStructure {

    public static void main(String[] args) {
        MapDataStructure cache = new MapDataStructure(2);
//["LRUCache","put","put","get","put","get","put","get","get","get"]
//      [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        System.out.println(cache.get(2));       // returns -1 (not found)
        //System.out.println(cache.get(2));       // returns -1 (not found)
        //System.out.println(cache.get(3));       // returns 3
        //System.out.println(cache.get(4));       // returns 4

        /*cache.put(2,1);
        cache.put(1,1);
       System.out.println(cache.get(1));       // returns -1 (not found)
        cache.put(2,3);
       System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4,1);
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(2));       // returns -1 (not found)
        //System.out.println(cache.get(4));       // returns -1 (not found)*/

        /*cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // returns -1 (not found)
        cache.put(3,3);
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4,4);
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns -1 (not found)
        System.out.println(cache.get(4));       // returns -1 (not found)*/

    }

    private Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> mapStack = new Stack<>();
    Queue<Integer> mapQueue = new ArrayDeque<>();
    private int capacity = 0;
    int mapSize = 0;

    public MapDataStructure(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        /*if(value != null){
            mapStack.push(key);
        }*/
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        if (this.capacity == (map.size())) {

            if(mapQueue.isEmpty()){
                for (int i = 0; i < capacity; i++) {
                    if (!mapStack.empty()) {
                        Integer removablelement = mapStack.pop();
                        mapQueue.add(removablelement);
                    }
                }
            }
            Integer removable = mapQueue.poll();
            map.remove(removable);
           /* if(mapSize>0)
            mapSize--;*/
        }

        if (map.size() > 0 && map.containsKey(key)) {
           /* for (Integer integer : mapQueue) {
                map.remove(integer);
                mapQueue.poll();
            }*/

            mapQueue.add(key);
        }

        if (map.size() == 0 || !map.containsKey(key)) {
            mapStack.push(key);
        }
        map.put(key, value);
    }
}

