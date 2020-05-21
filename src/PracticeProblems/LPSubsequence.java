package PracticeProblems;

public class LPSubsequence {

    public static void main(String[] args) {
        String s = "oklkko";
        System.out.println(longestPallindromic(s, 0, s.length() - 1));
    }
    static int longestPallindromic(String str, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }

        int s1 = 0;
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            s1 = 2 + longestPallindromic(str, startIndex + 1, endIndex - 1);
        }

        int s3 = longestPallindromic(str, startIndex + 1, endIndex);
        int s2 = longestPallindromic(str, startIndex, endIndex - 1);

        return Math.max(s1, Math.max(s2,s3));
    }

    static int maxOfNumbers(int[] arr, int index, int maxValue) {
        if (index >= arr.length) {
            return maxValue;
        }

        if (arr[index] > maxValue) {
            maxValue = arr[index];
        }

        return maxOfNumbers(arr, index + 1, maxValue);
    }
}
