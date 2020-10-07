package PracticeProblems;

public class PallindromicSubString {

    public static void main(String[] args) {
        String s = "sdsdassdaspopwedes";
        System.out.println(pallindromicSubString(s, 0, s.length() - 1));
    }

    static int pallindromicSubString(String str, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        int p1 = 0;
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            int remainingIndex = endIndex - startIndex - 1;
            if (remainingIndex == pallindromicSubString(str, startIndex + 1, endIndex - 1)) {
                p1 = 2 + remainingIndex;
            }
        }

        int p2 = pallindromicSubString(str, startIndex + 1, endIndex);
        int p3 = pallindromicSubString(str, startIndex, endIndex - 1);
        return Math.max(p1, Math.max(p2, p3));
        //return maximumOfTempArray(temp, 0, Integer.MIN_VALUE);
    }

    private static int maximumOfTempArray(int[] temp, int i, int maxValue) {
        if (i >= temp.length) {
            return maxValue;
        }

        if (temp[i] > maxValue) {
            maxValue = temp[i];
        }

        return maximumOfTempArray(temp, i + 1, maxValue);
    }
}
