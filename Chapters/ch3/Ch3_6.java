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
public class Ch3_6 {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()){
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
        
    }
}
