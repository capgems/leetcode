package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class findAnagramsInString {



    public static void main(String[] args) {
        String s = "bacaba";
        String p = "abc";
        System.out.println(findAnagramsInString(s,p));
    }

    static List<Integer> findAnagramsInString(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s.length() == 0) return result;
        int[] count_arr =   new int[26];
        for(char c: p.toCharArray()){
            count_arr[c-'a']++;
        }

        int left = 0;
        int right = 0;
        int count  = p.length();

        while( right < s.length()){
          if( count_arr[s.charAt(right++)-'a']-- >= 1) count--;

          if(count ==0) result.add(left);

          if(right - left == p.length() && count_arr[s.charAt(left++)-'a']++ >=0 ) {
                count++;
            }
        }

        return result;

    }


}
