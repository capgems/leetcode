package LeetCodePractice;

import java.util.*;

public class CommonElementsInTwoSortedArrays {

    public static void main(String[] args) {
        findCommonElements(new int[]{1, 3, 4, 5}, new int[]{0, 1, 3, 4}).forEach(System.out::println);
    }

    static List findCommonElements(int a[], int b[]) {
        List<Integer> result = new ArrayList<>();

        int x = 0, y = 0;

        while (y < b.length && x < a.length) {
            if (a[x] == b[y]) {
                result.add(a[x]);
                x++;
                y++;
            } else if (a[x] > b[y]) {
                y++;
            } else if (b[y] > a[x]) {
                x++;
            }
        }
        return result;
    }

}
