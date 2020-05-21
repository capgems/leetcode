package LeetCodePractice;

import java.util.Stack;

public class ValidateBinarySearchTreeNick {

    static boolean validateTree(ValidateBinarySearchTree.Node node) {

        Stack<ValidateBinarySearchTree.Node> nodeStack = new Stack<>();
        double leftNode = -Double.MAX_VALUE;

        while (!nodeStack.empty() || node != null) {
            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            node = nodeStack.pop();
            if (node.data <= leftNode) return false;
            leftNode = node.data;
            node = node.right;

        }
        return true;
    }
}
