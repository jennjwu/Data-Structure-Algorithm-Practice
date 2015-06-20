package Leetcode.reverseString;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by jennjwu on 6/20/15.
 */
public class Solution {
    public String reverseWords(String s) {
        //System.out.println("original: |" + s+"|");

        if(s.length() > 0){
            String[] split_s = s.split("\\s+");
            if(split_s.length > 0){
                ArrayList<String> new_s = new ArrayList();
                for (int i = split_s.length-1; i >= 0; i--){
                    if(!Objects.equals(split_s[i], " ") && !Objects.equals(split_s[i], "")){
                        //System.out.println("|" + split_s[i] + "|");
                        new_s.add(split_s[i]);
                    }
                }

                String final_s = "";
                for (String str: new_s){
                    //System.out.println(str);
                    final_s += str + " ";
                }
                //remove last space
                final_s = final_s.substring(0,final_s.length()-1);

                //System.out.println("new:      |" + final_s + "|");
                //System.out.println(final_s.length());
                return final_s;
            }
            else
                return "";
        }
        else
            return "";
    }
}
