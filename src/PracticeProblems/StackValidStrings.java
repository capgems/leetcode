package PracticeProblems;

import java.util.HashMap;
import java.util.Stack;

public class StackValidStrings {

    public static void main(String[] args) {
        solution();
        System.out.println(validate("[[[[{{}}"));
    }

    private static HashMap<Character, Character> mappings;

    static HashMap solution() {
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        return mappings;
    }

    static boolean validate(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == (')' | ']' | '}')) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);

            if (!mappings.containsKey(key)) {
                stack.push(key);
            } else {
                char mapValue = mappings.get(key);
                char stackValue = stack.pop();
                if (stackValue != mapValue) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
