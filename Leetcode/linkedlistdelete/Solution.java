package Leetcode.linkedlistdelete;

/**
 * Created by jennjwu on 11/7/15.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        // copy next node to the current node since we cannot access previous node
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
