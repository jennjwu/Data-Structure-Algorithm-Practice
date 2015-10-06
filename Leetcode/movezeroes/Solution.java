package Leetcode.movezeroes;

/**
 * Created by jennjwu on 10/4/15.
 */
public class Solution {
    public void moveZeroes(int[] nums) {

        for (int a = 0; a < nums.length; a++){
            System.out.println(nums[a]);
        }


        int frontIdx = 0;
        int zeroIdx = 0;

        for(int i = 0; i < nums.length; i++){
            int numZero = 0;
            frontIdx = i;
            zeroIdx = i;
            //get zeroes
            while(nums[zeroIdx] == 0 && zeroIdx < nums.length-1){
                numZero++;
                zeroIdx++;
            }

            //copy
            //System.out.println("number of zeroes: " + numZero);

            for(int cur = frontIdx; numZero > 0; cur++){
//                System.out.println(cur);
//                System.out.println(cur+numZero);
                nums[cur] = nums[cur+numZero];
                nums[cur+numZero] = 0;
                numZero--;
            }

        }

        System.out.println("------");
        for (int z = 0; z < nums.length; z++){
            System.out.println(nums[z]);
        }

    }
}
