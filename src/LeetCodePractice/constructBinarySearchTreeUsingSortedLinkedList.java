package LeetCodePractice;

public class constructBinarySearchTreeUsingSortedLinkedList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5, new ListNode(4,
                new ListNode(3, new ListNode(2, new ListNode(1, null)))));
        new constructBinarySearchTreeUsingSortedLinkedList().sortedListToBST(listNode);
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        //linked list to BST.
        return constructTree(head, null);


    }

    TreeNode constructTree(ListNode head, ListNode end) {


        if (head == end || head == null) return null; // important

        ListNode middleNode = findMidElement(head, end);


        TreeNode root = new TreeNode(middleNode.val);

        root.left = constructTree(head, middleNode);
        root.right = constructTree(middleNode.next, end);
        return root;

    }

    ListNode findMidElement(ListNode start, ListNode end) {

        ListNode fastNode = start;
        ListNode slowNode = start;

        while (fastNode.next != end && fastNode.next.next != end) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }
}
