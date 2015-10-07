package Leetcode.movezeroes;

/**
 * Created by jennjwu on 10/4/15.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.moveZeroes(new int[]{1,2,0,4,5});

        System.out.println("====");
        s.moveZeroes(new int[]{1, 0, 1, 0, 4, 5});

        System.out.println("====");
        s.moveZeroes(new int[]{0, 0, 4, 5});

        System.out.println("====");
        s.moveZeroes(new int[]{6, 0, 0, 0, 4, 0, 0, 5});

        System.out.println("====");
        s.moveZeroes(new int[]{1, 3, 1, 6, 4, 5});

        System.out.println("====");
        s.moveZeroes(new int[]{0, 0, 0, 0, 0, 0});

        System.out.println("====");
        s.moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});

        System.out.println("====");
        s.moveZeroes(new int[]{4,2,4,0,0,3,1,5,1,0});
    }
}
