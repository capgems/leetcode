package PracticeProblems;

import java.util.ArrayList;
import java.util.List;

public class ExtractStringFromString {

    static List ll = new ArrayList();

    public static void main(String[] args) {
        String s1 = "asdasdassdsdsadsdsaa";
        String s2 = "sdsa";
        List<Integer> ar = extractString(s1, s2);
        System.out.println("The Input string is: " + s2);
        if (ar != null && !ar.isEmpty()) {
            System.out.println("The Searched Output from index " + ar.get(0) + " to " + ar.get(1) + " " + s1.substring(ar.get(0), ar.get(1) + 1));
        } else {
            System.out.println("No results matched");
        }
    }

    static List extractString(String s1, String s2, int start, int end, int index) {

        if (start >= s1.length() || end >= s2.length()) {
            return null;
        }

        int count = 0;
        while (start <= s1.length() - 1 && index <= end) {
            if (s1.charAt(start) == s2.charAt(index)) {
                if (count < s2.length()) {
                    count++;
                    start++;
                    index++;
                }
            } else {
                start++;
                index = 0;
                count = 0;
            }
        }

        if (count == s2.length()) {
            ll.add(start - (s2.length()));
            ll.add(start - 1);
        }

        return ll;
    }

    static List extractString(String s1, String s2) {
        return extractString(s1, s2, 0, s2.length() - 1, 0);
    }
}
