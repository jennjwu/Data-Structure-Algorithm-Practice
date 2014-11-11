/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch2;

/**
 *
 * @author jennjwu
 */
public class Ch2_5 {
    //general linked list
    class Node {
        Node next = null;
        int data;
        
        public Node(int d) {
            data = d;
        }
        
        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next!=null) {
                n = n.next;
                //get to last node in list
            }
            n.next = end;//tack one the new node
        }
        
        Node deleteNode(Node head, int d) {
            Node n = head;
            if (n.data == d) {
                return head.next; //move head
            }
            while (n.next != null) {
                if (n.next.data == d) {
                    n.next = n.next.next;
                    return head; //head didn't change
                }
                n = n.next;
            }
            return head;
        }
    }
    
    
    
    //7 -> 1  -> 6
    //5 -> 9  -> 2
    //12 -> 10+1 -> 8+1
    
    Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        Node result = new Node(carry);
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        
        result.data = value%10; //second digit
        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null: l1.next, l2 == null ? null: l2.next, value >= 10 ? 1:0);
            result.next = more;
        }
        
        return result;
        
    }
}
