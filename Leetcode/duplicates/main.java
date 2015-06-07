package Leetcode.duplicates;

/**
 * Created by jennjwu on 6/7/15.
 */
public class main {
    public static void main(String[] args) {
        int[] intArr = new int[]{4,6,5,1,1,3,4,8,2};
        int[] intArr2 = new int[]{4,6,5,1,3,9,8,2};

        Duplicates test = new Duplicates();
        System.out.println(test.containsDuplicate(intArr)); //should be true
        System.out.println(test.containsDuplicate(intArr2));    //should be false

    }

}
