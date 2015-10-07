package Leetcode.onebits;

/**
 * Created by jennjwu on 10/5/15.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hammingWeight(100));

        System.out.println("\n------");

        System.out.println(s.hammingWeight(11));

        System.out.println("\n------");

        System.out.println(s.hammingWeight(2));

        System.out.println("\n------");

        System.out.println(s.hammingWeight(0));

        System.out.println("\n------");

        System.out.println(s.hammingWeight(5671));

        System.out.println("\n------");

        System.out.println(s.hammingWeight(Integer.parseUnsignedInt("2147483648")));

    }
}
