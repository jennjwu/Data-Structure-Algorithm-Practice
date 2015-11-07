package Leetcode.roman;

import java.util.HashMap;

/**
 * Created by jennjwu on 11/6/15.
 */
public class Solution {
    public int romanToInt(String s){
        System.out.println(s);

        int val = 0;

        HashMap<String, Integer> romans = new HashMap();
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);

        for (int i = 0; i < s.length(); i++){
            String letter = s.substring(i, i + 1);
//            System.out.println("Letter is: " + letter);

            if (i > 0) { //check if letter before is smaller, then do subtraction
                String previousLet = s.substring(i-1, i);
                if (romans.get(previousLet) < romans.get(letter)) {
//                    System.out.println("previous letter: " + previousLet);
                    val -= romans.get(previousLet) * 2;
                    val += romans.get(letter);
                } else {
                    val += romans.get(letter);
                }
            } else {
                val += romans.get(letter);
            }
//            System.out.println("val is now: " + val);
        }

        return val;
    }
}
