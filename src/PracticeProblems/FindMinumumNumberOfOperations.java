package PracticeProblems;

public class FindMinumumNumberOfOperations {

    public static void main(String[] args) {
        System.out.println(findMinimumOperations("elop", "tret", 0, 0));
    }

    private static int findMinimumOperations(String s1, String s2, int i1, int i2) {

        if (i1 >= s1.length()) {
            return s2.length() - i2;
        }
        if (i2 >= s2.length()) {
            return s1.length() - i1;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return findMinimumOperations(s1, s2, i1 + 1, i2 + 1);
        }

        int a = 1 + findMinimumOperations(s1, s2, i1 + 1, i2); // insert
        int b = 1 + findMinimumOperations(s1, s2, i1, i2 + 1); //delete
        int c = 1 + findMinimumOperations(s1, s2, i1 + 1, i2 + 1); //replace
        int[] temp = {a, b, c};
        int minValue = Integer.MAX_VALUE;
        return minimum(temp, 0, minValue);
    }

    private static int minimum(int[] arr, int index, int minValue) {

        if (index >= arr.length) {
            return minValue;
        }

        if (arr[index] < minValue) {
            minValue = arr[index];
        }

        return minimum(arr, index + 1, minValue);
    }
}
