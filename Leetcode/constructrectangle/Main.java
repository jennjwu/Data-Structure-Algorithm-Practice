package Leetcode.constructrectangle;

/**
 * Created by jennjwu on 3/1/17.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] result = s.constructRectangle(4);
        System.out.println(result[0] + " " + result[1]);
        System.out.println("------");
        System.out.println(s.constructRectangle(12));
        System.out.println("------");
        System.out.println(s.constructRectangle(2));
    }
}
