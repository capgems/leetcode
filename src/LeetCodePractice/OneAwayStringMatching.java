package LeetCodePractice;

public class OneAwayStringMatching {

    public static void main(String[] args) {
     /*   System.out.println(oneAwayString("abcde", "abcd"));  // should return true
        System.out.println(oneAwayString("abde", "abcde"));  // should return true
        System.out.println(oneAwayString("a", "a"));  // should return true
        System.out.println(oneAwayString("abcdef", "abqdef"));  // should return true
        System.out.println(oneAwayString("abcdef", "abccef"));  // should return true*/
        System.out.println(oneAwayString("bcaef", "caef"));  // should return true
       // System.out.println(oneAwayString("abcdef", "abcde"));  // should return true
   /*     System.out.println(oneAwayString("aaa", "abc"));  // should return false
        System.out.println(oneAwayString("abcde", "abc"));  // should return false
        System.out.println(oneAwayString("abc", "abcde"));  // should return false
        System.out.println(oneAwayString("abc", "bcc"));  // should return false*/
    }

    static boolean oneAwayString(String s1, String s2) {

        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) {
            return false;
        }
        if (s1.length() == s2.length()) {
            return oneAwayStringSameLength(s1, s2);
        }

        if (s1.length() > s2.length()) {
            return oneAwayStringDiffLengths(s1, s2);
        } else {
            return oneAwayStringDiffLengths(s2, s1);
        }
    }

    static boolean oneAwayStringSameLength(String s1, String s2) {
        int i = 0, count_diff = 0;
        while (i < s1.length()) {

            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                count_diff++;
                i++;
            }
        }
        return count_diff <= 1;
    }

    static boolean oneAwayStringDiffLengths(String s1, String s2) {
        int i = 0, count_diff = 0;

        while ((i + count_diff) < s1.length() && i < s2.length()) {
            if (s1.charAt(i + count_diff) == s2.charAt(i)) {
                i++;
            } else {
                count_diff++;
            }
        }

        return count_diff <= 1;
    }
}
