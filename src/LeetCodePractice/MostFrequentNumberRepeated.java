package LeetCodePractice;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberRepeated {


    public static void main(String[] args) {

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(mostRepeatedNumber(array1, new HashMap<Integer, Integer>(), 0, Integer.MIN_VALUE,0));

//        System.out.println(computeTheMostCalculatedNumber(array5, 0, new HashMap<>(), -1));
//        System.out.println(computeTheMostCalculatedNumber(array1, 0, new HashMap<>(), -1));
//        System.out.println(computeTheMostCalculatedNumber(array3, 0, new HashMap<>(), -1));
//        System.out.println(computeTheMostCalculatedNumber(array4, 0, new HashMap<>(), -1));
//        System.out.println(computeTheMostCalculatedNumber(array2, 0, new HashMap<>(), -1));
    }


    static Integer computeTheMostCalculatedNumber(int arr[], int index, Map<Integer, Integer> map, int maxCount) {

        if (arr.length == 0) {
            return null;
        }

        if (map.containsKey(arr[index])) {
            map.put(arr[index], map.get(arr[index]) + 1);
        } else {
            map.put(arr[index], 1);
        }

        if (map.get(arr[index]) > maxCount) {
            maxCount = map.get(arr[index]);
        }

        if (index == arr.length - 1) {
            return maxCount;
        }

        return computeTheMostCalculatedNumber(arr, index + 1, map, maxCount);


        //  return maxOfNumbers(map.values().stream().mapToInt(Integer::intValue).toArray(), 0, Integer.MIN_VALUE);
    }


    static Integer mostRepeatedNumber(int[] array, Map<Integer, Integer> map, int key, int max, int maxNumber) {

        if (key >= array.length) return maxNumber;

        if (map.containsKey(array[key])) {
            map.put(array[key], map.get(array[key]) + 1);
        } else {
            map.put(array[key], 1);
        }

        max = Math.max(map.get(array[key]), max);
        if(map.get(array[key]) >= max){
            maxNumber =array[key];
        }

        return mostRepeatedNumber(array, map, key + 1, max,maxNumber);
    }

}
