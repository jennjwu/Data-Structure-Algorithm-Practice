/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch2;

/**
 *
 * @author jennjwu
 */
public class Ch2_4 {
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
    
    
    public Node partition(Node node, int x) {
        Node lessSt = null;
        Node lessEnd = null;
        Node greaterSt = null;
        Node greaterEnd = null;
        
        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if (lessSt == null) {
                    //lower half not started yet
                    //set first node of lower half
                    lessSt = node;
                    lessEnd = lessSt;
                }
                else {
                    lessEnd.next = node;
                    lessEnd = node;
                }
            }
            else {
                //larger - insert upper list
                if (greaterSt == null) {
                    greaterSt = node;
                    greaterEnd = greaterSt;
                }
                else {
                    greaterEnd.next = node;
                    greaterEnd = node;
                }
            }
            node = node.next;
            
            
        }
        
        if (lessSt == null) {
            //lower list empty
            return greaterSt;
        }
        
        lessEnd.next = greaterSt;
        return lessSt;
    }
}
