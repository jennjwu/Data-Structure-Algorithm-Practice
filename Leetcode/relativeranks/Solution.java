import java.util.Arrays;

class Solution {
	public String[] findRelativeRanks(int[] nums) {
    	// create an array with ordered indexes 0 to n-1, where n is length of nums 
    	Integer[] index = new Integer[nums.length];
    	for (int j = 0; j < nums.length; j++) {
            index[j] = j;
        }
        
        // sort index array based on rank of nums array using lambda expression
    	Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

    	String[] result = new String[nums.length];

    	for (int i = 0; i < nums.length; i++) {
    		System.out.println("i = " + i + " numCopy[i] is " + nums[i]);
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}