package LeetCodePractice;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String characters = "({{()}})";
        System.out.println(checkBrackets(characters));
    }


    static boolean checkBrackets(String s) {


        Stack<Character> characterStack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                if ('{' != characterStack.pop()) {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if ('[' != characterStack.pop()) {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if ('(' != characterStack.pop()) {
                    return false;
                }
            } else {
                characterStack.push(s.charAt(i));
            }
        }

        return true;
    }
}
