package LeetCodePractice;

import java.util.Arrays;

public class TwoNumbers {

    public static void main(String[] args) {
        Arrays.stream(twoNumbersTargetProblem(new int[]{3, 2, 4}, 6)).forEach(System.out::println);
    }

    static int[] twoNumbersTargetProblem(int arr[], int target) {

        for (int i = 0; i < arr.length; i++) {
            int remain = target - arr[i], j = i + 1;
            while (j > 0 && j < arr.length) {
                if (arr[j] == remain) {
                    return new int[]{i, j};
                }
                j++;
            }
        }
        return null;
    }
}
