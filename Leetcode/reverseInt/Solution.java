package Leetcode.reverseInt;

import java.util.Stack;

/**
 * Created by jennjwu on 6/16/15.
 */
public class Solution {
    public int reverse(int x) {
        //System.out.println("original: "+x);
        boolean neg = false;
        if(x < 0){
            x *= -1;
            neg = true;
        }

        Stack<Integer> digitQ = new Stack();
        int num = x;
        while(num > 10){
            int digit = num % 10;
            digitQ.push(digit);
            num /= 10;
        }
        if(num == 10){
            digitQ.push(0);
            digitQ.push(1);
        }
        else{
            digitQ.push(num);
        }

        int newNum = 0;
        int length = digitQ.size()-1;

        //TODO: does not test for int overflow yet

        for (int i = 0; i < digitQ.size(); i++){
            newNum += digitQ.get(i)* Math.pow(10, length);
            length--;
        }

        if(neg){
            newNum *= -1;
        }

        //System.out.println("new: " + newNum);
        return newNum;
    }
}
