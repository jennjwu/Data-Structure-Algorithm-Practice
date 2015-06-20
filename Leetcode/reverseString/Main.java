package Leetcode.reverseString;

/**
 * Created by jennjwu on 6/20/15.
 */
public class Main {
    public static void main(String[] args) {
        /*
        String[] test = {"this is a test", "reverse me yes no maybe", "yah okay yah",
                "hello world what is going on here", "the sky is blue", " "};
        */

        String[] test = {"   1     2", "test       blah  a "," job well done  ",""};

        Solution sol = new Solution();
        for (String s: test){
            System.out.println(sol.reverseWords(s));
        }
    }
}
