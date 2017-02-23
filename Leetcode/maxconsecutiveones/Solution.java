package Leetcode.maxconsecutiveones;

/**
 * Created by jennjwu on 2/22/17.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currentConsecutive = 0;
        for (int i = 0; i < nums.length; i++){
//            System.out.println(nums[i]);
            if (nums[i] == 1) {
                currentConsecutive++;
            } else {
                currentConsecutive = 0;
            }

            if (currentConsecutive > maxConsecutive) {
                maxConsecutive = currentConsecutive;
            }
        }
        return maxConsecutive;
    }
}
