public class Solution {
    public String reverseWords(String s) {
        char[] inputStr = s.toCharArray();
        int substringSt = 0;
        
        for (int i = 0; i < inputStr.length; i++) {
            // System.out.println(inputStr[i]);
            
            // found space
            if (inputStr[i] == ' ') {
                reverse(substringSt, i - 1, inputStr);
                substringSt = i + 1;
            }

            // rever the last segment if no trailing space
            if (i == inputStr.length - 1) {
                reverse(substringSt, i, inputStr);
            }
        }
        
        return new String(inputStr);
    }
    
    private void reverse(int start, int end, char[] input) {
        while (start <= end) {
            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            start++;
            end--;
        }
    }
}