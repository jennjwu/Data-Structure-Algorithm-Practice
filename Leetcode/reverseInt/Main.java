package Leetcode.reverseInt;

/**
 * Created by jennjwu on 6/16/15.
 */
public class Main {
    public static void main(String[] args) {
        int[] intArr = new int[]{10,200,100,101,111,211,51101,-1,-20,-612361,-92010};
        Solution sol = new Solution();
        for (int i: intArr){
            System.out.println("----------");
            System.out.println(sol.reverse(i));
        }
    }
}
