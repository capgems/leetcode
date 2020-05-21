package LeetCodePractice;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagram(new String[]{"abc", "cba", "eat", "ate"}));
    }

    static List<List<String>> groupAnagram(String[] strs) {

        Map<String, List<String>> groupAnagram = new HashMap<>();

        List<List<String>> ana = new ArrayList<>();

        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String s = new String(characters);

            if (!groupAnagram.containsKey(s)) {
                groupAnagram.put(s, new ArrayList<String>());
            }
            groupAnagram.get(s).add(str);
        }

        ana.addAll(groupAnagram.values());

        return ana;


    }
}
