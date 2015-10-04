package Leetcode.anagram;

import java.util.Arrays;

/**
 * Created by jennjwu on 10/4/15.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        } else {
            String[] oriArr = new String[s.length()];
            String[] anaArr = new String[t.length()];
            for(int i = 0; i < s.length(); i++){
                oriArr[i] = Character.toString(s.charAt(i));
                anaArr[i] = Character.toString(t.charAt(i));
            }

            Arrays.sort(oriArr);
            Arrays.sort(anaArr);

//            for(int i = 0; i < s.length(); i++){
//                System.out.println(oriArr[i]);
//            }
//
//            System.out.println("-----");
//
//            for(int i = 0; i < s.length(); i++){
//                System.out.println(anaArr[i]);
//            }

            for(int i = 0; i < s.length(); i++){
                if(!oriArr[i].equals(anaArr[i])){
                    //System.out.println(oriArr[i] + " " + anaArr[i]);
                    return false;
                }
            }
            return true;
        }
    }
}
