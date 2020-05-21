package LeetCodePractice;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {

      /*  int num, temp, digit, count = 0;

        //getting the number from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number:");
        num = scanner.nextInt();
        scanner.close();

        //making a copy of the input number
        temp = num;

        //counting digits in the input number
        while (num > 0) {
            num = num / 10;
            count++;
        }
        while (temp > 0) {
            digit = temp % 10;
            System.out.println("Digit at place " + count + " is: " + digit);
            temp = temp / 10;
            count--;
        }*/
        System.out.println(longestSubString("ssbb"));
    }

    static int longestSubString(String s) {
        HashSet set = new HashSet();
        int max = 0;

        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(set.size(), max);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return set.size();
    }

    static int sortNumbers(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }

                if (min != i) {
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }
            }

        }
        return arr[arr.length - 1];
    }


}

