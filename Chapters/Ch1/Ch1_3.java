
package ch1;

import java.util.Arrays;

public class Ch1_3 {
    public static void main(String[] args) {
        String str1 = "abacus";
        String str2 = "calcul";
        System.out.println(permutation(str1,str2));
        
        String str3 = "dog";
        String str4 = "god";
        System.out.println(permutation(str3,str4));
    }
    
    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    /*public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }*/
    
    //alternative way
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256]; //Asssumption on use of ASCII
        char[] s_array = s.toCharArray();
        //for each loop (for each char c in s_array)
        for (char c: s_array) {
            letters[c]++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
}
