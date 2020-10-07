package PracticeProblems;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {20, 10, 90, 50, 40, 30, 5};
        insertionSort(arr);
    }

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i], j = i;
            while (j > 0 && arr[j - 1] > currentNumber) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = currentNumber;
        }
        Arrays.stream(arr).forEach(System.out::print);

    }

}
