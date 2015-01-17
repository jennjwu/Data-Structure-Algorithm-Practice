package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Practice {

    /**
     * anagram puzzle
     */
    public static void main(String[] args) {
        String test1 = "abccde";
        String test2 = "badcce";
        String test3 = "bbad";
        String test4 = "dbab";
        
        boolean result;
        
        /*result = isAnagram(test1,test2);
        result = isAnagram(test1,test3);
        result = isAnagram(test1,test4);
        result = isAnagram(test2,test3);
        result = isAnagram(test2,test4);
        result = isAnagram(test3,test4);*/
        
        
        result = isAnagramHash(test1,test2);
        result = isAnagramHash(test1,test3);
        result = isAnagramHash(test1,test4);
        result = isAnagramHash(test2,test3);
        result = isAnagramHash(test2,test4);
        result = isAnagramHash(test3,test4);

    }
    
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() == s2.length()){
            char[] cArr = s1.toCharArray();
            char[] cArr2 = s2.toCharArray();
            Arrays.sort(cArr);
            Arrays.sort(cArr2);
            
            if (Arrays.equals(cArr, cArr2)){
                System.out.println(s1 + " and " + s2 + " are anagrams!");
                return true;
            }
            else {
                System.out.println(s1 + " and " + s2 + " are not anagrams");
                return false;
            }            
        }
        else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
            return false;
        }   
    }
    
    public static boolean isAnagramHash(String s1, String s2){
        if (s1.length() == s2.length()){
            char[] cArr = s1.toCharArray();
            char[] cArr2 = s2.toCharArray();
            
            HashMap<Character,Integer> map = new HashMap<>();
            for (char c: cArr){
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
                else {
                    map.put(c,1);
                }
            }
            
            /*
            Iterator<Character> keySetIterator = map.keySet().iterator();
            while(keySetIterator.hasNext()){
                char key = keySetIterator.next();
                System.out.println("key: " + key + " value: " + map.get(key));
            }*/

            
            //match string 2 to charArr of string 1
            for (char c: cArr2){
                if (map.containsKey(c)){
                    if ((map.get(c)-1) == 0) {
                        map.remove(c);
                    }
                    else {
                        map.put(c,map.get(c)-1);
                    }
                }
                else {
                    System.out.println(s1 + " and " + s2 + " are not anagrams");
                    return false;
                }
                
            }
            
            //if map is empty then strings are anagrams
            if (map.isEmpty()){
                System.out.println(s1 + " and " + s2 + " are anagrams!");
                return true;
            }
            else {
                System.out.println(s1 + " and " + s2 + " are not anagrams");
                return false;
            }            
        }
        else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
            return false;
        }
    }
}
