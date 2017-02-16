package Leetcode.keyboard;

import java.util.ArrayList;

/**
 * Created by jennjwu on 2/13/17.
 */
public class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> results = new ArrayList<String>();

        String row1 = new String("qwertyuiop");
        String row2 = new String("asdfghjkl");
        String row3 = new String("zxcvbnm");

        for (String w : words) {
            String wordAsLower = w.toLowerCase();
            if (charsAllInString(0, wordAsLower, row1) || charsAllInString(0, wordAsLower, row2) || charsAllInString(0, wordAsLower, row3)) {
                results.add(w);
            }
        }

        return results.toArray(new String[0]);
    }

    private boolean charsAllInString(int idx, String s, String row) {
        if (idx < s.length()) {
            if (row.indexOf(s.charAt(idx)) > -1) {
                return charsAllInString(++idx, s, row);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}