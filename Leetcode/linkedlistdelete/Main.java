package Leetcode.linkedlistdelete;

/**
 * Created by jennjwu on 11/7/15.
 */
import Leetcode.linkedlistdelete.ListNode;

public class Main {
    public static ListNode makeList() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        return head;
    }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        // print tail node
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode test = makeList();
        ListNode ptr = test;

        System.out.println("----before----");
        printList(ptr);

        s.deleteNode(test.next.next); // delete n2 node

        System.out.println("----after----");
        printList(test);

        ListNode test2 = makeList();
        ListNode ptr2 = test2;

        System.out.println("----before----");
        printList(ptr2);

        s.deleteNode(test2.next.next.next); // delete n3 node

        System.out.println("----after----");
        printList(test2);
    }
}
