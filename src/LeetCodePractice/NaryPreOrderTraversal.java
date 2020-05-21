package LeetCodePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NaryPreOrderTraversal {

    List<Integer> nodes = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        return preOrder(root);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> preOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        nodes.add(root.val);
        for (Node node : root.children) {
            preOrder(node);
        }
        return nodes;
    }

    // without recursion

    List<Integer> preOrderwithOutRecursion(Node root) {

        LinkedList<Node> stackNodes = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root == null) {
            return output_arr;
        }

        stackNodes.add(root);

        while (!stackNodes.isEmpty()) {
            Node node = stackNodes.pollLast();
            if (node != null) {

                output_arr.add(node.val);
                Collections.reverse(node.children);
                node.children.stream().forEach(e -> stackNodes.add(e));
            }

        }

        return output_arr;
    }
}
