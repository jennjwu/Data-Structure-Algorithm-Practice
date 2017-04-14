import java.util.Arrays;

public class Solution {
    public char findTheDifference(String s, String t) {
        char[] original = s.toCharArray();
        Arrays.sort(original);

        // for (char c: original) {
        //     System.out.print(c);    
        // }
        
        char[] compareStr = t.toCharArray();
        Arrays.sort(compareStr);

        // System.out.println("");

        // for (char c: compareStr) {
        //     System.out.println(c);    
        // }
        
        for (int i = 0; i < compareStr.length; i++) {
            if (i < original.length && original[i] != compareStr[i]) {
                return compareStr[i];    
            }
        }

        return compareStr[compareStr.length - 1];
    }
}