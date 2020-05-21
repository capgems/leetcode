package PracticeProblems;

import java.util.stream.IntStream;

public class TestThread {

    int[][] arr; // declaring an array

    TestThread(int noOfRows, int noOfColms) {
        arr = new int[noOfRows][noOfColms]; // instantiation of an array
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColms; col++) {
                arr[row][col] = Integer.MIN_VALUE; //  initialization of an array.
            }
        }
    }
}
