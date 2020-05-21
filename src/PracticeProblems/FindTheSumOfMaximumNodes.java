package PracticeProblems;

public class FindTheSumOfMaximumNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static int maxLen = 0;
    static int maxSum = Integer.MIN_VALUE;

    static int maximumSumOfNodes(Node node,int len, int sum){
        if(node == null){
            maxLen = len;
            maxSum = sum;
            return maxSum;
        }

       return Math.max(maximumSumOfNodes(node.left,len+1,sum+node.data),maximumSumOfNodes(node.right,len+1,sum+node.data));
    }

    public static void main(String[] args) {
        // binary tree formation
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);

        System.out.println( "Sum = "
                + maximumSumOfNodes(root,0,0));
    }
}