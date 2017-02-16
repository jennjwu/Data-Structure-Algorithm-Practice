package Leetcode.keyboard;

/**
 * Created by jennjwu on 2/13/17.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.findWords(new String[]{"test", "something", "aaa"}));

        String[] results = s.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        System.out.println("----- results -----");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
