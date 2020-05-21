package PracticeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon1 {

    public int solution(int N, String S) {
        Map<Character, Integer> indexMap = getCharacterIntegerMap();
        Map<Integer, List<Integer>> filledSeatsMapRowWise = getSeatsMap(S, indexMap);
        filledSeatsMapRowWise.entrySet().forEach(System.out::println);

        int count = 0;

        for(int i = 1 ; i <= N;i++){
            List<Integer> filledSeats = filledSeatsMapRowWise.get(i);

            //1 1-4
            boolean first = checkIfIndexExists(filledSeats,1,4);
            if(first == true)
                count++;

            //2 3-6
            boolean second = false;
            if(first == false){
                second = checkIfIndexExists(filledSeats,3,6);
                if(second)
                    count++;
            }


            //3 5 - 8
            boolean third = false;
            if(second == false){
                third = checkIfIndexExists(filledSeats,5,8);
                if(third)
                    count++;
            }

        }



        return count;
    }

    private boolean checkIfIndexExists(List<Integer> filledSeats,int start,int end) {
        if(filledSeats != null){
            for (int x : filledSeats) {
                if(x >=start && x <=end)
                    return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharacterIntegerMap() {
        Map<Character, Integer> indexMap = new HashMap<>();
        indexMap.put('A', 0);
        indexMap.put('B', 1);
        indexMap.put('C', 2);
        indexMap.put('D', 3);
        indexMap.put('E', 4);
        indexMap.put('F', 5);
        indexMap.put('G', 6);
        indexMap.put('H', 7);
        indexMap.put('J', 8);
        indexMap.put('K', 9);
        return indexMap;
    }

    private Map<Integer, List<Integer>> getSeatsMap(String S, Map<Character, Integer> indexMap) {
        Map<Integer, List<Integer>> filledSeats = new HashMap<>();
        for (int i = 0; i < S.length() - 1; i = i + 3) {
            int rowNum = S.charAt(i) - '0';
            int index = indexMap.get(S.charAt(i + 1));

            List<Integer> list = filledSeats.get(rowNum);

            if (list == null)
                list = new ArrayList<>();

            list.add(index);
            filledSeats.put(rowNum, list);
        }
        return filledSeats;
    }

    public static void main(String[] args) {
        int N = 5;
        String S = "0A 2F 1C 3E";
        System.out.println(new Amazon1().solution(N, S));
    }

}

