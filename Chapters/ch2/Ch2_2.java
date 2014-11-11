/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch2;

/**
 *
 * @author jennjwu
 */
public class Ch2_2 {
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
        
        Node nthToLast(Node head, int k) {
            if (k <= 0) return null;
            
            Node p1 = head;
            Node p2 = head;
            
            for (int i = 0; i < k-1; i++) {
                if (p2 == null) return null;
                p2 = p2.next;
            }
            if (p2 == null) return null;
            
            while (p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
                //when p2 is null, then p1 pointing to kth to last elem
                
            }
            return p1;
        }
        
    }
    
    
    
}
