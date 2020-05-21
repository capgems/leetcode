package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        //preorderTraversal();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {

            Stack<TreeNode> s = new Stack<>();
            s.push(root);

            while (!s.empty()) {
                root = s.pop();
                list.add(root.val);

                if (root.right != null) {
                    s.push(root.right);
                }

                if (root.left != null) {
                    s.push(root.left);
                }

            }

            return list;
        }
        return new ArrayList();
    }
}
