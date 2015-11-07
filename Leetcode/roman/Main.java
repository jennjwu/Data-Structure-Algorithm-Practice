package Leetcode.roman;

/**
 * Created by jennjwu on 11/6/15.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("============");
        int myInt1 = s.romanToInt("X");
        System.out.println(myInt1);

        System.out.println("============");
        int myInt2 = s.romanToInt("VII");
        System.out.println(myInt2);

        System.out.println("============");
        int myInt3 = s.romanToInt("LX");
        System.out.println(myInt3);

        System.out.println("============");
        int myInt4 = s.romanToInt("MMDCCLI");
        System.out.println(myInt4);

        System.out.println("============");
        int myInt5 = s.romanToInt("CDXLVIII");
        System.out.println(myInt5);

        System.out.println("============");
        int myInt6 = s.romanToInt("MMMCMXCIX");
        System.out.println(myInt6);

    }
}
