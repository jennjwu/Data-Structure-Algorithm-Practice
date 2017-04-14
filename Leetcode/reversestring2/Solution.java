import java.util.ArrayList;

public class Solution {
    public String reverseStr(String s, int k) {
        // string is less than k length, reverse all chars
        if (k > s.length()) {
        	return reverseSubstring(s);
        } else {
            ArrayList<String> result = new ArrayList<>();
            int numParts = s.length() / k;
            
            // if not divisible, round up because there is a trailing section
            if (s.length() % k > 0) {
                numParts++;
            }

            // increase by 2 parts each time because we iterate through 2k each time
            for (int parts = numParts, i = 0; i < parts; i += 2) {
                // if the substring is less than k length
                int minIndexForFlip = Math.min(i * k + k, s.length());
                String toFlip = reverseSubstring(s.substring(i * k, minIndexForFlip));

                // if the substring is between k and 2k length
                int minIndexForNoFlip = Math.min(i * k + 2 * k, s.length());
                String noFlip = "";
                if (s.length() > i * k + k) {
                    noFlip = s.substring(i * k + k, minIndexForNoFlip);
                }

                result.add(toFlip + noFlip);
            }
            return String.join("", result);
        }
    }

    private String reverseSubstring(String s) {
        char[] charArr = new char[s.length()];
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            charArr[j] = s.charAt(i);
        }
        return new String(charArr);
    }
}