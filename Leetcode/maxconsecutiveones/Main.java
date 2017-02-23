package Leetcode.maxconsecutiveones;

/**
 * Created by jennjwu on 2/22/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] intArr = new int[]{1,1,0,1,1,1};
        int[] intArr2 = new int[]{1,1,1,0,1,1,1};
        int[] intArr3 = new int[]{1,1,1,0,1,1,1,0,1,0,1,1,1,1,0};
        int[] intArr4 = new int[]{0,0,0,0};

        Solution test = new Solution();
        int result = test.findMaxConsecutiveOnes(intArr);
        System.out.println(result);

        int result2 = test.findMaxConsecutiveOnes(intArr2);
        System.out.println(result2);

        int result3 = test.findMaxConsecutiveOnes(intArr3);
        System.out.println(result3);

        int result4 = test.findMaxConsecutiveOnes(intArr4);
        System.out.println(result4);
    }
}
