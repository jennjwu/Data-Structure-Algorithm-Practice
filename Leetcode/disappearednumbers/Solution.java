import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> visitedNums = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
        	// 1 <= a <= n is boundary of array
        	// 0 <= x <= n-1 is array width
        	// so subtract one from current value @ array idx
            int val = Math.abs(nums[i]) - 1;

            // if the value is not negative, we have not seen this value before
            // flip the sign now that we have seen it
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int idx = 0; idx < nums.length; idx++) {
        	if (nums[idx] > 0) {
        		// if value at the idx is greater than 0, this idx is not a value in the original array
        		// add the idx as value to result
        		visitedNums.add(idx + 1);
        	}
        }

        return visitedNums;
    }
}