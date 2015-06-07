package Leetcode.singlenum;

public class Main {

    public static void main(String[] args) {
        int[] intArr = new int[]{4,5,5,1,1,3,4,2,2};

        Single test = new Single();
        int result = test.singleNumber(intArr);
        System.out.println(result);

    }
}
