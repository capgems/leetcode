package LeetCodePractice;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Node node =
                new Node(4,
                        new Node(1, new Node(0), new Node(2)),
                        new Node(5, new Node(4), new Node(6)));

        System.out.println(validateGivenBinaryTree(node,null,null));
    }

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node() {
        }
    }

    static boolean validateGivenBinaryTree(Node node, Integer max  , Integer min) {
        if (max != null && max < node.data) {
            return false;
        }

        if (min != null && min > node.data) {
            return false;
        }

        boolean isLeftBst = true;
        boolean isRightBst = true;

        if (node.left != null)
            isLeftBst = validateGivenBinaryTree(node.left, node.data, min);
        if (node.right != null)
            isRightBst = validateGivenBinaryTree(node.right, max, node.data);

        return isLeftBst && isRightBst;
    }
}
