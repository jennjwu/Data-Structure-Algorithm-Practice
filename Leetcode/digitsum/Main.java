package Leetcode.digitsum;

/**
 * Created by jennjwu on 10/3/15.
 */
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("====");
        System.out.println(s.addDigits(5));

        System.out.println("====");
        System.out.println(s.addDigits(51234));

        System.out.println("====");
        System.out.println(s.addDigits(38));

        System.out.println("====");
        System.out.println(s.addDigits(10));
    }
}
