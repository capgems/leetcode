package LeetCodePractice;

public class MinimumBinaryTreeDepth {

    int minimumTreeDepth(TreeNode node) {

        if (node == null) return 0;

        if (node.left == null && node.right == null) return 1;

        int leftPath = node.left != null ? minimumTreeDepth(node.left) : Integer.MAX_VALUE;
        int rightPath = node.right != null ? minimumTreeDepth(node.right) : Integer.MAX_VALUE;

        return Math.min(leftPath, rightPath) + 1; // replace min with max for maximum binary tree depth
    }
}
