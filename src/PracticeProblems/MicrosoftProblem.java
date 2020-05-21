package PracticeProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MicrosoftProblem {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter the no of ingredients");

        final long noOfIngredients = Integer.parseInt(br.readLine());
        System.out.println("please enter the partitioned values for each ingredient.");
        String[] eachIngredientData = null;
        eachIngredientData = br.readLine().split(" ");
        long[] intArray = Arrays.stream(eachIngredientData).mapToLong(Long::new).toArray();
        System.out.println("please enter the quantity values for each ingredient.");

        String[] quantityOfEach = null;
        quantityOfEach = br.readLine().split(" ");
        long[] qIntArray = Arrays.stream(quantityOfEach).mapToLong(Long::new).toArray();

        List<Long> integers = new ArrayList<>();

        for (long z = 0, i = 0; z < qIntArray.length; z++, i++) {
            long e = qIntArray[(int) z] / intArray[(int) z];
            integers.add(e);
        }

        Optional<Long> s = integers.stream().min(Comparator.comparingLong(Long::intValue));
        System.out.println(s.get());
    }
}
