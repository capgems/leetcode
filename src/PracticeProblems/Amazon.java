package PracticeProblems;

import java.util.HashMap;
import java.util.Map;
/*Input :   1
         /    \
        2      3
        / \    / \
       4   5  6   3
                \   \
                 8   9

      ex : 1-3-6-8.
                 */
public class Amazon {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.l = new Tree(2);
        root.r = new Tree(3);
        root.l.l = new Tree(4);
        root.l.r = new Tree(5);
        root.r.l = new Tree(6);
        root.r.r = new Tree(7);
        root.r.l.r = new Tree(8);
        root.r.r.r = new Tree(9);
        System.out.println(solution(root));
    }

    static int solution(Tree T, Map<Integer, Integer> distinctNodes) {
        if (T == null) {
            return distinctNodes.size();
        }
        if (distinctNodes.containsKey(T.value)) {
            return distinctNodes.size();
        } else {
            distinctNodes.put(T.value, 1);
        }
        int distinctLongPath = Math.max(solution(T.l, distinctNodes), solution(T.r, distinctNodes));
        if (distinctNodes.containsKey(T.value)) {
            distinctNodes.put(T.value, distinctNodes.get(T.value) - 1);
        }
        if (distinctNodes.get(T.value) == 0) {
            distinctNodes.remove(T.value);
        }
        return distinctLongPath;
    }

    static int solution(Tree T) {
        Map<Integer, Integer> distinctNodes = new HashMap<>();
        return solution(T, distinctNodes);
    }
}

class Tree {
    public int value;
    public Tree l;
    public Tree r;

    public Tree(int value) {
        this.value = value;
    }
}

