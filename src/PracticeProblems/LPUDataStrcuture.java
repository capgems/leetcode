package PracticeProblems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LPUDataStrcuture {

    public static void main(String[] args) {
        LPUDataStrcuture cache = new LPUDataStrcuture(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns -1 (not found)
        cache.put(3, 3);
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns -1 (not found)
        System.out.println(cache.get(4));       // returns -1 (not found)

    }

    private Map<Integer, Integer> map;
    private Map<Integer, Integer> rankingMap;
    private int capacity;

    LPUDataStrcuture(int capacity) {
        this.map = new HashMap<>(capacity);
        this.rankingMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        int computedRank;
        if (rankingMap.size() == 0) {
            computedRank = 0;
        } else {
            computedRank = computeRank(rankingMap, false);
        }
        if (map.size() > 0 && (this.capacity == map.size())) {
            int computeLeastRank = computeRank(rankingMap, true);
            for (Map.Entry entry : rankingMap.entrySet()) {
                if (entry.getValue().equals(computeLeastRank)) {
                    map.remove(entry.getKey());
                }
            }
        }

        if (map.size() > 0 && map.containsKey(value)) {
            rankingMap.put(key, computedRank + 1);
            map.put(key, value);

        } else {
            if (rankingMap.size() == 0) {
                computedRank = 0;
            }
            rankingMap.put(key, computedRank + 1);
            map.put(key, value);
        }

    }

    private int computeRank(Map<Integer, Integer> rankingMap, boolean isLeast) {
        Collection<Integer> set = rankingMap.values();
        int[] arr = new int[set.size()];
        int i = 0;
        for (Integer var : set) {
            arr[i] = var;
            i++;
        }
        if (isLeast) {
            return findMinElement(arr, 0, Integer.MAX_VALUE);
        }
        return findMaxElement(arr, 0, Integer.MIN_VALUE);
    }


    static int findMaxElement(int[] arr, int index, int max) {

        if (index >= arr.length) {
            return max;
        }

        if (arr[index] > max) {
            max = arr[index];
        }
        return findMaxElement(arr, index + 1, max);
    }

    static int findMinElement(int[] arr, int index, int min) {

        if (index >= arr.length) {
            return min;
        }

        if (arr[index] < min) {
            min = arr[index];
        }
        return findMinElement(arr, index + 1, min);
    }
}
