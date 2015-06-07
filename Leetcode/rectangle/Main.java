package Leetcode.rectangle;

/**
 * Created by jennjwu on 6/7/15.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("overlap right bottom");
        System.out.println("    AREA is: " + sol.computeArea(-3,0,3,4,0,-1,9,2));

        System.out.println("overlap right top");
        System.out.println("    AREA is: " + sol.computeArea(-3,0,3,4,0,2,9,6));

        System.out.println("overlap left bottom");
        System.out.println("    AREA is: " + sol.computeArea(-3,0,3,4,-5,-1,0,2));

        System.out.println("overlap left top");
        System.out.println("    AREA is: " + sol.computeArea(-3,0,3,4,-5,1,0,6));

        System.out.println("encompass");
        System.out.println("    AREA is: " + sol.computeArea(-3,0,3,4,-2,1,2,2));
        System.out.println("    AREA is: " + sol.computeArea(-2,-2,2,2,-1,-1,1,1));

        System.out.println("complete overlay");
        System.out.println("    AREA is: " + sol.computeArea(-2,-2,2,2,-2,-2,2,2));


        System.out.println("    AREA is: " + sol.computeArea(-2,-2,2,2,1,-3,3,3));
    }
}
