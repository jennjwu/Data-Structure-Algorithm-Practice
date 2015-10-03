package Leetcode.digitsum;

/**
 * Created by jennjwu on 10/3/15.
 */
public class Solution {
    public int addDigits(int num) {
        int[] intArr = new int[Integer.toString(num).length()];
        int i = intArr.length-1;

        //convert to digits
        while(num >= 10){
            intArr[i] = num % 10;
            num /= 10;
            i--;
        }
        intArr[i] = num;

        for(int j = 0; j < intArr.length; j++){
            System.out.println(intArr[j]);
        }
        System.out.println("----");

        if(intArr.length > 1){
            int sum = 0;
            for (int k = 0; k < intArr.length; k++){
                sum += intArr[k];
            }
            return addDigits(sum);
        } else {
            return num;
        }

    }
}
