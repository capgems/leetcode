package LeetCodePractice;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        //System.out.println(firstUniqChar("epam"));
        System.out.println(firstUniqCharMap("loveleetcode"));
    }

    public static int firstUniqChar(String s) {

 // O(N^2)

        for (int i = 0; i < s.length(); i++) {
                boolean seen = false;
            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j) && (i != j)) {
                    seen = true;
                    break;
                }
            }
            if( !seen ) return i;
        }

        return -1;
    }

    public static int firstUniqCharMap(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i< s.length(); i++){

            if(!map.containsKey( s.charAt(i) )){
                map.put(s.charAt(i),1);
            }else{
                char chare = s.charAt(i);
                map.put(s.charAt(i),map.get(chare)+1);
            }
        }

        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            if( map.get(ch) == 1 ){
                return j;
            }
        }

        return -1;

    }

}
