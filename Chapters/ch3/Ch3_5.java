/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch3;

import java.util.Stack;

/**
 *
 * @author jennjwu
 */
public class Ch3_5 {
    public class MyQueue<T> {
        //implement queue using 2 stacks
        //queue is FIFO but stack is LIFO
        Stack<T> stackNewest, stackOldest;
        
        public MyQueue(){
            //keep newest on top
            stackNewest = new Stack<T>();
            
            //keep oldest on top
            //if empty, transfer all of stackNewst here, then pop
            stackOldest = new Stack<T>();
        }
        
        public int size() {
            return stackNewest.size() + stackOldest.size();
        }
        
        public void add(T value) {
            stackNewest.push(value);
        }
        
        private void shiftStacks() {
            //pop from stackOldest
            if (stackOldest.isEmpty()) {
                //transfer all items from stackNewest to Oldest
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }
        
        public T peek() {
            //first shift stacks
            shiftStacks();
            return stackOldest.peek();
        }
        
        public T remove() {
            shiftStacks();
            return stackOldest.pop();
        }
        
        
    }
}
