package Leetcode.robber;

/**
 * Created by jennjwu on 6/7/15.
 */
public class Solution {
    public int rob(int[] num) {
        //From leetcode
        //For every house k, there are two options:
            // either to rob it (include this house: i) or
            // not rob it (exclude this house: e).

        //Include this house: i = num[k] + e
        // (money of this house + money robbed excluding the previous house)

        //Exclude this house: e = max(i, e)
        // (max of money robbed including the previous house or money robbed excluding the previous house)
        // (note that i and e of the previous step, that's why we use tmp here to store the previous i
        // when calculating e, to make O(1) space)

        int i = 0;
        int e = 0;
        for (int k = 0; k<num.length; k++) {
            int tmp = i; //current loot - starts at 0 and represents robbing previous house
            i = num[k] + e; //rob current house
            e = Math.max(tmp, e); //maximum of loot w/ previous house and loot w/o previous house
            //pick the one that returns the most loot
        }
        return Math.max(i,e);
    }
}
