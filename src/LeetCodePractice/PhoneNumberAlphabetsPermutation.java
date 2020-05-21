package LeetCodePractice;

import java.util.LinkedList;
import java.util.List;

/*
* Time complexity of this below program was T(n) = O( 3^M 4^N ) S(N) = O( 3^M 4^N )
* */

public class PhoneNumberAlphabetsPermutation {


    public static void main(String[] args) {
        System.out.println("final arr_outpu.."+letterCombinations("56"));
    }

    public static List<String> letterCombinations(String digits) {

        LinkedList<String> outputCombination = new LinkedList<>();

        if (digits.length() == 0) return outputCombination;

        outputCombination.add("");

        String[] charMap = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        for (int k = 0; k < digits.length(); k++) {

            while (outputCombination.peek().length() == k) {
                String permutation = outputCombination.remove();

                for (char character : charMap[Character.getNumericValue(digits.charAt(k))].toCharArray()) {

                    outputCombination.add(permutation + character);
                    System.out.print("At digit index: " + k + " " + permutation);
                    System.out.println("Combined permutation.." + permutation + " " + character);
                }

            }

        }
        return outputCombination;
    }

}
