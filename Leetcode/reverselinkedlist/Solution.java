import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Use a stack to reverse the linked list
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            Stack<ListNode> s = new Stack<>();
            
            ListNode current = head;
            while (current != null) {
                // make a copy of the current node so we can change its pointer
                ListNode copyCurrentNode = new ListNode(current.val);
                // this is the head node, which will become the tail node when reversed, so its next should be null
                if (s.empty()) {
                    copyCurrentNode.next = null;
                } else {
                    // reverse the current nodes pointer to point the previous node (already on the stack)
                    copyCurrentNode.next = s.peek();
                }
                s.push(copyCurrentNode);
                current = current.next; // iterate through the original linked list
            }

            return s.pop(); // we only need to pop the top element on the stack bc we have already reversed the pointers
        } else {
            return head;
        }
    }
}