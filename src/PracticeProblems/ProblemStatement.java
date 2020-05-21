package PracticeProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ProblemStatement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter the kinds of books");

        final int kindOfBooks = Integer.parseInt(br.readLine());

        System.out.println("please enter the partitioned values for each kind of books");
        String[] eachNumberOfBooks = null;

        eachNumberOfBooks = br.readLine().split(" ");

        int[] intArray = Arrays.stream(eachNumberOfBooks).mapToInt(Integer::new).toArray();
        int remainder = -1;
        List<Integer> intergers = new ArrayList<>();
        for (int z = 0; z < intArray.length; z++) {
            for (int j = 2; j < intArray[z] / 2; j++) {
                remainder = intArray[z] % j;
                if (remainder == 0) {
                    intergers.add(j);
                }
            }
        }

        Optional<Integer> s = intergers.stream().filter(i -> Collections.frequency(intergers, i) >= kindOfBooks).max(Comparator.comparingInt(Integer::intValue));
        System.out.println(s.isPresent() ? s.get() : "cannot be determined");
    }
}
