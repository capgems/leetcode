package LeetCodePractice;

import java.util.HashMap;

import static LeetCodePractice.LCA.createTree;

public class MaxPathSum {

    // case 1: If the straight path value is the max value
    // case 2: If the sp value is less that the root+left+right means root is in the max path values then current max is max of between them
    // case 3: if the current node is at the out of the max path. that means compare the result of the previous value and update the max path sum every time

    // in case 1 always return the straight path in the recursive as we don't know whether the current node is in the max_path or not so
    // always adding up the straight path to the result value.

    public static void main(String[] args) {

        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
        int[] childrenD = {1, 4};
        int[] childrenE = {3, 8};
        int[] childrenF = {9, 2};
        int[] childrenG = {6, 7};
        mapping2.put(5, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);
        mapping2.put(3, childrenG);

        TreeNode head2 = createTree(mapping2, 5);

        maxPathSum(head2);
        System.out.println(result);
    }

    static int result = Integer.MIN_VALUE;

  /*  static int maxPathSum(TreeNode node) {

        if(node == null) return 0;

        int left = maxPathSum(node.left);
        int right = maxPathSum(node.right);

        int sp = Math.max(Math.max(left, right) + node.value, node.value);
        int currNodeInPath = Math.max(sp, left + right + node.value);
        result = Math.max(currNodeInPath, result);
        return sp;
    }*/

    static int maxPathSum(TreeNode treeNode) {
        if (treeNode == null) return 0;

        int left = maxPathSum(treeNode.left);
        int right = maxPathSum(treeNode.right);

        int sp = Math.max(Math.max(left, right) + treeNode.value, treeNode.value);
        int currentNodePath = Math.max(sp, left + right + treeNode.value);
        result = Math.max(currentNodePath, result);
        return sp;

    }
}
