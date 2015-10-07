package Leetcode.onebits;

/**
 * Created by jennjwu on 10/5/15.
 */
public class Solution {
    public int hammingWeight(int n) {
//        System.out.println(Integer.toBinaryString(n));
        int[] binaryInt = new int[32];
        int i = 0;
        while(n >= 2){
            //System.out.println(n + " " + n % 2);
            binaryInt[i] = n % 2;
            n /= 2;
            i++;
        }
        binaryInt[i] = n; //add last byte

        //System.out.println("==");
        int numOnes = 0;
        for(int k = 0; k < binaryInt.length; k++){
            if(binaryInt[k] == 1){
                numOnes++;
            }
            //System.out.print(binaryInt[k]);
        }

        return numOnes;

        //accepted solution below
//        public int hammingWeight(int n) {
//            int count = 0;
//
//            while(n != 0){
//                if((n & 1) == 1) count++;
//                n >>>= 1;
//            }
//            return count;
//        }
    }
}
