/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch2;

import java.util.Hashtable;

/**
 *
 * @author jennjwu
 */
public class Ch2_1 {
    public static void main(String[] args) {
        
    }
    
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
    
    
    /*public static void deleteDups(LinkedListNode n) {
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        
        while (n!= null) {
            if (table.containsKey(n.data)) {
                //already in there
                previous.next = n.next;
            }
            else {
                //hash table put(key, value)
                table.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
    }*/
    
    //no buffer allowed
    public static void deleteDups(Node head) {
        if (head == null) return;
        
        Node current = head; //start at head
        while (current != null) {
            Node runner = current; //second runner pointer
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next; //skip
                }
                else {
                    runner = runner.next;
                }
                current = current.next;
            }
            
        }
    }
    
}
