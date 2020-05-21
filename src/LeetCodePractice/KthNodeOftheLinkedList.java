package LeetCodePractice;

public class KthNodeOftheLinkedList {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(5, new ListNode(4,
                new ListNode(3, new ListNode(2, new ListNode(1, null)))));

        System.out.println(findTheKthElementInTheList(listNode, 3).data);
    }

    static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode node) {
            this.next = node;
            this.data = data;
        }
    }

    static ListNode findTheKthElementInTheList(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;

        for (int i = 1; i <= n + 1; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return slowNode;
    }
}
