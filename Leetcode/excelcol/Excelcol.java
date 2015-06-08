package Leetcode.excelcol;

/**
 * Created by jennjwu on 3/6/15.
 */

//Like bit manipulation, except base is now 26 instead of 2 or 10.

public class Excelcol {
    public int titleToNumber(String s) {
        String col = s.toUpperCase();
        int result = 0;
        for (int i = s.length() - 1, digit = 1; i>=0; i--){
            result += digit * ((int)(col.charAt(i)) - 64);
            digit *= 26; //each digit, multiply by 26 for A-Z
        }
        return result;
    }
}
